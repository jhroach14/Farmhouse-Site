package com.webu.urban.storage.imageUtil;

import com.webu.urban.storage.StorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class BufferedImageThumbnailer {

    private static final ImageObserver DUMMY_OBSERVER = (img, infoflags, x, y, width, height) -> true;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final int maxLongSide;

    public BufferedImageThumbnailer(int maxLongSide){

        this.maxLongSide = maxLongSide;
        log.debug("Initialized image thumbnailler");
    }

    public Path thumbify(Path srcPath) {


        try{
            String thumbStr = srcPath.toString();
            log.debug("attempting to thumbify img at path "+thumbStr);
            String first = thumbStr.substring(0,thumbStr.indexOf("/img/")+5);
            String middle = "thumb/";
            String last = thumbStr.substring(thumbStr.indexOf("/img/")+5);
            thumbStr = first+middle+last;
            log.debug("parsed new thumb path as "+thumbStr);

            Path thumbPath = Paths.get(thumbStr);
            Files.deleteIfExists(thumbPath);
            thumbPath = Files.createFile(thumbPath);
            log.debug("created empty thumbfile at "+thumbPath.toString());
            BufferedImage imgIn = ImageIO.read(srcPath.toFile());
            log.debug("reading in img from "+ srcPath.toString());

            double scale;
            if(imgIn.getWidth() >= imgIn.getHeight()){
                //horizontal or square img
                scale = Math.min(maxLongSide, imgIn.getWidth()) / (double) imgIn.getWidth();
            }else{
                //vertical img
                scale = Math.min(maxLongSide, imgIn.getHeight()) / (double) imgIn.getHeight();
            }
            log.debug("Image scale calculated to be " +scale);

            BufferedImage thumbOut = new BufferedImage((int)(scale*imgIn.getWidth()),(int)(scale*imgIn.getHeight()),imgIn.getType());
            Graphics2D g = thumbOut.createGraphics();
            AffineTransform transform = AffineTransform.getScaleInstance(scale,scale);
            g.drawImage(imgIn,transform,DUMMY_OBSERVER);
            ImageIO.write(thumbOut,"jpeg",thumbPath.toFile());
            log.debug("thumbnail written to filesystem at "+thumbPath.toString());

            return thumbPath;

        }catch(Exception e){
            log.error("thumbnail processing error \n"+e.getMessage());
            throw new StorageException("thumbnail processing error",e);
        }

    }
}
