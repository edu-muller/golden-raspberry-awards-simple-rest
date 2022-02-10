package com.raspberry.parser.csv;

import com.opencsv.bean.customconverter.ConverterLanguageToBoolean;

public class ConvertYesToBoolean<T, I> extends ConverterLanguageToBoolean<T, I> {
	
	private static final String YES = "yes";
	private static final String EMPTY = "";
	private static final String[] TRUE_STRINGS = { YES };
	private static final String[] FALSE_STRINGS = { EMPTY };
	
	@Override
	protected String getLocalizedTrue() {
		return YES;
	}
	
	@Override
	protected String getLocalizedFalse() {
		return EMPTY;
	}
	
	@Override
	protected String[] getAllLocalizedTrueValues() {
		return TRUE_STRINGS;
	}
	
	@Override
	protected String[] getAllLocalizedFalseValues() {
		return FALSE_STRINGS;
	}
}