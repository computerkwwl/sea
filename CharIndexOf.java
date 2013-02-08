//$Id: CharIndexOf.java,v 1.1 2013-2-8 zhouqi Exp $
/*
 *
 * KINGSTAR MEDIA SOLUTIONS Co.,LTD. Copyright c 2005-2006. All rights reserved.
 * 
 * This source code is the property of KINGSTAR MEDIA SOLUTIONS LTD. It is intended 
 * only for the use of KINGSTAR MEDIA application development. Reengineering, reproduction
 * arose from modification of the original source, or other redistribution of this source 
 * is not permitted without written permission of the KINGSTAR MEDIA SOLUTIONS LTD.
 * 
 */
/********************************************************************************
 * @author zhouqi
 * 
 * MODIFICATION DESCRIPTION
 * 
 * Name                 Date                Description 
 * ============         ============        ============
 * zhouqi				2013-2-8             Created
 *  
 ********************************************************************************/

/**
 * 
 */
package com.mystudio;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhouqi
 * 
 */
public class CharIndexOf {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //          012345678901234
        String a = "a33331212333132";
        String b = "33313";
        a.indexOf(0
                );
        System.out.println(sdf.format(new Date()));
        for (int i = 0; i < 100000000; i++) {
            new CharIndexOf().indexOf(a.toCharArray(), b.toCharArray());
        }
        System.out.println(sdf.format(new Date()));
        System.out.println(sdf.format(new Date()));
        for (int i = 0; i < 100000000; i++) {
            a.indexOf(b);
        }
        System.out.println(sdf.format(new Date()));
    }
    
    public int indexOf(char[] a, char[] b) {
        if (b.length == 0) {
            return 0;
        }
        
        if (a.length == 0 && b.length != 0 || a.length < b.length) {
            return -1;
        }
        
        int foundLength = 0;
        for (int i = 0; i < a.length;) {
            foundLength = 0;
            for (int j = 0; j < b.length;) {
                if (a[i] == b[j]) {
                    i++;
                    j++;
                    foundLength++;
                    if (foundLength >= b.length) {
                        return i - foundLength;
                    }
                } else {
                    i -= (foundLength - 1);
                    if (i < 0) {
                        i = 0;
                    }
                    foundLength = 0;
                    j = 0;
                    if (b[j] == a[i++]) {
                        foundLength++;
                        j++;
                    }
                }
            }
        }
        
        return -1;
    }
}
