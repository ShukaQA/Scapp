/*

protected TPage uploadFile(By selector, String fileType) {


    if (Device().isAndroidPlatform()) {
        action.click(getDriver().findElement(selector)).perform();
        driverManager.switchToNativeContext();
        switch (fileType) {
            case "JPG" -> click(commonElements.jpgAndroid());
            case "PNG" -> click(commonElements.pngAndroid());
            case "GIF" -> click(commonElements.gifAndroid());
            case "JPG2MB" -> click(commonElements.twoMBFile());
            case "MP4" -> {
                elementDoesNotExist(commonElements.mp4Android());
                click(commonElements.jpgAndroid());
            }
            case "PDF" -> {
                elementDoesNotExist(commonElements.pdfAndroid());
                click(commonElements.jpgAndroid());
            }
        }
    } else {
        click(selector);
        driverManager.switchToNativeContext();
        getDriver().findElement(commonElements.photoLibraryIos()).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(commonElements.photoIos()));
        switch (fileType) {
            case "JPG" -> getDriver().findElements(commonElements.photoIos()).get(0).click();
            case "PNG" -> getDriver().findElements(commonElements.photoIos()).get(1).click();
            case "GIF" -> getDriver().findElements(commonElements.photoIos()).get(2).click();
            case "MP4" -> {
                elementDoesNotExist(commonElements.mp4Ios());
                getDriver().findElements(commonElements.photoIos()).get(1).click();
            }
            case "PDF" -> {
                elementDoesNotExist(commonElements.pdfIos());
                getDriver().findElements(commonElements.photoIos()).get(1).click();
            }
            case "JPG2MB" -> {
                getDriver().findElements(commonElements.photoIos()).get(4).click();
            }
        }
        click(commonElements.doneIos());
    }

    driverManager.switchToWebViewContext();

    return getPage();
}*/
