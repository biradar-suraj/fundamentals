package org.drogo.basics.designpatterns.factory;

public class WindowsOS extends OperatingSystem{
    public WindowsOS(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {

    }

    @Override
    public void removeDir(String dir) {

    }
}
