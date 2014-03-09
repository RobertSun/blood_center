package com.jeecms.cms.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CMS_CHNL_MODEL_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CMS_CHNL_MODEL_ITEM"
 */

public abstract class BaseChnlModelItem  implements Serializable {

	private static final long serialVersionUID = 3087313174445943560L;
	public static String REF = "ChnlModelItem";
	public static String PROP_DATA_TYPE = "dataType";
	public static String PROP_INPUT_SIZE = "inputSize";
	public static String PROP_PREDEFINE = "predefine";
	public static String PROP_HELP = "help";
	public static String PROP_ITEM_TYPE = "itemType";
	public static String PROP_PRIORITY = "priority";
	public static String PROP_CHECKED = "checked";
	public static String PROP_LABEL = "label";
	public static String PROP_INPUT_WIDTH = "inputWidth";
	public static String PROP_INPUT_TYPE = "inputType";
	public static String PROP_MODEL = "model";
	public static String PROP_DEF_VALUE = "defValue";
	public static String PROP_TEXTAREA_ROWS = "textareaRows";
	public static String PROP_NAME = "name";
	public static String PROP_OPTION_VALUE = "optionValue";
	public static String PROP_ID = "id";
	public static String PROP_TEXTAREA_COLS = "textareaCols";


	// constructors
	public BaseChnlModelItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseChnlModelItem (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseChnlModelItem (
		java.lang.Long id,
		com.jeecms.cms.entity.ChnlModel model,
		java.lang.Integer itemType,
		java.lang.String name,
		java.lang.Integer priority,
		java.lang.Boolean predefine,
		java.lang.Boolean checked) {

		this.setId(id);
		this.setModel(model);
		this.setItemType(itemType);
		this.setName(name);
		this.setPriority(priority);
		this.setPredefine(predefine);
		this.setChecked(checked);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.Integer itemType;
	private java.lang.String name;
	private java.lang.String label;
	private java.lang.String help;
	private java.lang.Integer dataType;
	private java.lang.Integer inputType;
	private java.lang.Integer inputSize;
	private java.lang.Integer inputWidth;
	private java.lang.Integer textareaCols;
	private java.lang.Integer textareaRows;
	private java.lang.String defValue;
	private java.lang.String optionValue;
	private java.lang.Integer priority;
	private java.lang.Boolean predefine;
	private java.lang.Boolean checked;

	// many to one
	private com.jeecms.cms.entity.ChnlModel model;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="MITEM_ID"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: MITEM_TYPE
	 */
	public java.lang.Integer getItemType () {
		return itemType;
	}

	/**
	 * Set the value related to the column: MITEM_TYPE
	 * @param itemType the MITEM_TYPE value
	 */
	public void setItemType (java.lang.Integer itemType) {
		this.itemType = itemType;
	}



	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: LABEL
	 */
	public java.lang.String getLabel () {
		return label;
	}

	/**
	 * Set the value related to the column: LABEL
	 * @param label the LABEL value
	 */
	public void setLabel (java.lang.String label) {
		this.label = label;
	}



	/**
	 * Return the value associated with the column: HELP
	 */
	public java.lang.String getHelp () {
		return help;
	}

	/**
	 * Set the value related to the column: HELP
	 * @param help the HELP value
	 */
	public void setHelp (java.lang.String help) {
		this.help = help;
	}



	/**
	 * Return the value associated with the column: DATA_TYPE
	 */
	public java.lang.Integer getDataType () {
		return dataType;
	}

	/**
	 * Set the value related to the column: DATA_TYPE
	 * @param dataType the DATA_TYPE value
	 */
	public void setDataType (java.lang.Integer dataType) {
		this.dataType = dataType;
	}



	/**
	 * Return the value associated with the column: INPUT_TYPE
	 */
	public java.lang.Integer getInputType () {
		return inputType;
	}

	/**
	 * Set the value related to the column: INPUT_TYPE
	 * @param inputType the INPUT_TYPE value
	 */
	public void setInputType (java.lang.Integer inputType) {
		this.inputType = inputType;
	}



	/**
	 * Return the value associated with the column: INPUT_SIZE
	 */
	public java.lang.Integer getInputSize () {
		return inputSize;
	}

	/**
	 * Set the value related to the column: INPUT_SIZE
	 * @param inputSize the INPUT_SIZE value
	 */
	public void setInputSize (java.lang.Integer inputSize) {
		this.inputSize = inputSize;
	}



	/**
	 * Return the value associated with the column: INPUT_WIDTH
	 */
	public java.lang.Integer getInputWidth () {
		return inputWidth;
	}

	/**
	 * Set the value related to the column: INPUT_WIDTH
	 * @param inputWidth the INPUT_WIDTH value
	 */
	public void setInputWidth (java.lang.Integer inputWidth) {
		this.inputWidth = inputWidth;
	}



	/**
	 * Return the value associated with the column: TEXTAREA_COLS
	 */
	public java.lang.Integer getTextareaCols () {
		return textareaCols;
	}

	/**
	 * Set the value related to the column: TEXTAREA_COLS
	 * @param textareaCols the TEXTAREA_COLS value
	 */
	public void setTextareaCols (java.lang.Integer textareaCols) {
		this.textareaCols = textareaCols;
	}



	/**
	 * Return the value associated with the column: TEXTAREA_ROWS
	 */
	public java.lang.Integer getTextareaRows () {
		return textareaRows;
	}

	/**
	 * Set the value related to the column: TEXTAREA_ROWS
	 * @param textareaRows the TEXTAREA_ROWS value
	 */
	public void setTextareaRows (java.lang.Integer textareaRows) {
		this.textareaRows = textareaRows;
	}



	/**
	 * Return the value associated with the column: DEF_VALUE
	 */
	public java.lang.String getDefValue () {
		return defValue;
	}

	/**
	 * Set the value related to the column: DEF_VALUE
	 * @param defValue the DEF_VALUE value
	 */
	public void setDefValue (java.lang.String defValue) {
		this.defValue = defValue;
	}



	/**
	 * Return the value associated with the column: OPTION_VALUE
	 */
	public java.lang.String getOptionValue () {
		return optionValue;
	}

	/**
	 * Set the value related to the column: OPTION_VALUE
	 * @param optionValue the OPTION_VALUE value
	 */
	public void setOptionValue (java.lang.String optionValue) {
		this.optionValue = optionValue;
	}



	/**
	 * Return the value associated with the column: PRIORITY
	 */
	public java.lang.Integer getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: PRIORITY
	 * @param priority the PRIORITY value
	 */
	public void setPriority (java.lang.Integer priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: IS_PREDEFINE
	 */
	public java.lang.Boolean getPredefine () {
		return predefine;
	}

	/**
	 * Set the value related to the column: IS_PREDEFINE
	 * @param predefine the IS_PREDEFINE value
	 */
	public void setPredefine (java.lang.Boolean predefine) {
		this.predefine = predefine;
	}



	/**
	 * Return the value associated with the column: IS_CHECKED
	 */
	public java.lang.Boolean getChecked () {
		return checked;
	}

	/**
	 * Set the value related to the column: IS_CHECKED
	 * @param checked the IS_CHECKED value
	 */
	public void setChecked (java.lang.Boolean checked) {
		this.checked = checked;
	}



	/**
	 * Return the value associated with the column: MODEL_ID
	 */
	public com.jeecms.cms.entity.ChnlModel getModel () {
		return model;
	}

	/**
	 * Set the value related to the column: MODEL_ID
	 * @param model the MODEL_ID value
	 */
	public void setModel (com.jeecms.cms.entity.ChnlModel model) {
		this.model = model;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.jeecms.cms.entity.ChnlModelItem)) return false;
		else {
			com.jeecms.cms.entity.ChnlModelItem chnlModelItem = (com.jeecms.cms.entity.ChnlModelItem) obj;
			if (null == this.getId() || null == chnlModelItem.getId()) return false;
			else return (this.getId().equals(chnlModelItem.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}