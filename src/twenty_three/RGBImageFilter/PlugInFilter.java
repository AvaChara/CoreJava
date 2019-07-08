package twenty_three.RGBImageFilter;//package twenty_three.RGBImageFilter;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

public interface PlugInFilter{
    java.awt.Image filter(java.applet.Applet a,java.awt.Image in);


}

