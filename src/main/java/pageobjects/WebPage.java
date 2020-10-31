package pageobjects;


import com.google.common.flogger.FluentLogger;

import static com.google.common.flogger.FluentLogger.*;

public abstract class WebPage {

    protected static final FluentLogger logger = forEnclosingClass();
    protected String url;

}

