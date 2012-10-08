package edu.wpi.cs.wpisuitetng.janeway;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads modules of the given type from JAR files
 * located in the given directory.
 *
 * @param <T> the type of the modules to load
 */
public class ModuleLoader<T> {
	
	/** The directory where the module config file is located */
	private String configPath;
	
	/** A list of directories where module jars are located */
	List<String> modPaths = new ArrayList<String>();
	
	/** A list of class names that contain modules */
	List<String> classNames = new ArrayList<String>();
	
	/** A list of URL objects pointing to the jar files */
	private List<URL> jarNames = new ArrayList<URL>();
	
	/** An array of URL objects, to be passed to the class loader */
	private URL[] urlArray = new URL[5];
	
	/** The class loader */
	private URLClassLoader classLoader;
	
	/** List of loaded modules */
	private List<T> modules = new ArrayList<T>();
	
	/**
	 * Creates a new ModuleLoader that loads modules of type <T>
	 * from the given directory.
	 * 
	 * @param modPath the directory containing module JAR files
	 */
	@SuppressWarnings("unchecked")
	public ModuleLoader(String configPath) {
		this.configPath = configPath;
		
		// Read the module configuration file to get paths and class names
		readConfig();
		
		// Find all the jar files
		for (String path : modPaths) {
			jarNames.addAll(getJarNames(path));
		}
		
		// Instantiate the class loader
		urlArray = jarNames.toArray(urlArray);
		classLoader = URLClassLoader.newInstance(urlArray);
		
		// Instantiate all of the modules and add them to the module array
		for (String modClass : classNames) {
			Class<?> currClass;
			try {
				currClass = classLoader.loadClass(modClass);
				System.out.println("Loaded module " + currClass.getName());
				modules.add((T) currClass.newInstance());
				
			} catch (ClassNotFoundException e) {
				System.out.println("The class " + modClass + " could not be found!");
				e.printStackTrace();
			} catch (InstantiationException e) {
				System.out.println("The class " + modClass + " could not be instantiated!");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println("Could not access constructor for class " + modClass + "!");
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Returns the list of instantiated modules
	 * @return the list of instantiated modules
	 */
	public List<T> getModules() {
		return modules;
	}
	
	/**
	 * Builds a list of all of the JAR files in the
	 * given directory.
	 * 
	 * @param path the directory to look in
	 * @return a list of JAR files in the given directory
	 */
	private List<URL> getJarNames(String path) {
		ArrayList<URL> retVal = new ArrayList<URL>();
		File jarDir = new File(path);
		String[] children = jarDir.list();
		for (String currJar : children) {
			try {
				retVal.add(new URL("jar", "", "file:" + path + "/" + currJar));
			} catch (MalformedURLException e) {
				System.out.println("Could not open jar file: " + currJar);
				e.printStackTrace();
			}
		}
		return retVal;
	}
	
	/**
	 * Reads the configuration file at path and parses out the module
	 * directories and the names of the module classes.
	 */
	private void readConfig() {
		BufferedReader configFile;
		String currLine;
		
		try {
			configFile = new BufferedReader(new FileReader(configPath)); // open the config file
			while ((currLine = configFile.readLine()) != null) {
				if (currLine.startsWith("#")) { // make sure this line is not a comment
					// this line is a comment, do nothing
				}
				else if (currLine.toLowerCase().startsWith("module_path")) {
					String[] tokens = currLine.split(" ");
					for (int i = 1; i < tokens.length; i++) {
						modPaths.add(tokens[i]);
					}
				}
				else if (currLine.toLowerCase().startsWith("module_class")) {
					String[] tokens = currLine.split(" ");
					for (int i = 1; i < tokens.length; i++) {
						classNames.add(tokens[i]);
					}
				}
				else {
					// do nothing, line not recognized
				}
			}
			configFile.close(); // close the config file
		} catch (FileNotFoundException e) {
			System.out.println("Could not open config file!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading config file!");
			e.printStackTrace();
		}
	}
}
