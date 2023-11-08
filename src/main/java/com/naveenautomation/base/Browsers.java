package com.naveenautomation.base;

public enum Browsers {
	
	CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
	OPERA("Operaa");

    private String browserName;

    Browsers(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }
	
}
