package org.ImprovedMC.Lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Lang {

	private File langFile;
	private Properties langProp = new Properties();

	private String defaultString = "{STR_ERR}";
	

	/**
	 * @param langFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public Lang(File langFile) throws FileNotFoundException, IOException {
		if(langFile != null){
			if(langFile.isFile()){
				this.langFile = langFile;
				this.langProp.load(new FileInputStream(langFile));
			} else {
				throw new FileNotFoundException("Could not find langFile");
			}
		} else {
			throw new NullPointerException("langFile is null");
		}
	}
	
	/**
	 * @param langFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public Lang(String langFilePath) throws FileNotFoundException, IOException {
		this(new File(langFilePath));
	}
	
	/**
	 * @param langFile
	 * @param createNew
	 * @param overwriteOld
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public Lang(File langFile, boolean createNew, boolean overwriteOld) throws IOException {
		if(langFile != null){
			
			this.langFile = langFile;
			
			if(createNew && (!this.langFile.isFile() || overwriteOld)){
				this.langFile.createNewFile();
			}
			
			if(this.langFile.isFile()){
				this.langProp.load(new FileInputStream(this.langFile));
			} else {
				throw new FileNotFoundException("Could not find langFile");
			}
		} else {
			throw new NullPointerException("langFile is null");
		}
	}
	
	/**
	 * @param langFile
	 * @param createNew
	 * @param overwriteOld
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public Lang(String langFile, boolean createNew, boolean overwriteOld) throws IOException {
		this(new File(langFile), createNew, overwriteOld);
	}
	
	/**
	 * @param defStr
	 */
	public void setDefaultString(String defStr) {
		this.defaultString = defStr != null ? defStr : "";
	}
	
	/**
	 * @return
	 */
	public String getDefaultString(){
		return this.defaultString;
	}
	
	/**
	 * @return
	 */
	public File getLangFile(){
		return this.langFile;
	}
	
	/**
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean addString(String key, String value){
		return addString(key, value, false);
	}
	
	/**
	 * @param key
	 * @param value
	 * @param overwrite
	 * @return
	 */
	public boolean addString(String key, String value, boolean overwrite){
		if(!this.langProp.containsKey(key) || overwrite){
			this.langProp.setProperty(key, value);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @throws IOException
	 */
	public void saveLangFile() throws IOException {
		saveLangFile(this.langFile);
	}
	
	/**
	 * @param langFile
	 * @throws IOException
	 */
	public void saveLangFile(File langFile) throws IOException {
		if(langFile != null) {
			FileOutputStream fos = new FileOutputStream(langFile);
			this.langProp.store(fos, "");
			
			fos.flush();
			fos.close();
		} else {
			throw new NullPointerException("langFile is null");
		}
	}
	
	/**
	 * @param key
	 * @return
	 */
	public String getString(String key){
		return this.langProp.getProperty(key, this.defaultString);
	}
	
}
