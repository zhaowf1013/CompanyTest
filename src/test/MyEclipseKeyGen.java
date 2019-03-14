package test;
import java.util.Scanner;
/**
 * MyEclipse(8.0,7.5,7.0,6.5,6.0...)µÄ×¢²áÂëÉú³É´úÂë
 *
 * @Time 2009-12-25
 */

public class MyEclipseKeyGen {
    private static final String LL = "Decompiling this copyrighted software is a violation of both your license agreement and the Digital Millenium Copyright Act of 1998 (http://www.loc.gov/copyright/legislation/dmca.pdf). Under section 1204 of the DMCA, penalties range up to a $500,000 fine or up to five years imprisonment for a first offense. Think about it; pay for a license, avoid prosecution, and feel better about yourself.";
    public MyEclipseKeyGen() {
    }
    /**
     * ¾ßÌåµÄSubscription CodeÉú³ÉËã·¨
     *
     * @param
     *
     * @param licenseNum
     * @return Subscription Code
     */
    public String getSerial(String subscriber, String licenseNum) {
        java.util.Calendar cal = java.util.Calendar.getInstance();// »ñµÃµ±Ç°ÈÕÆÚ

        cal.add(1, 3);// +3Äê

        cal.add(6, -1);// µ±Ç°ÈÕ-1

        java.text.NumberFormat nf = new java.text.DecimalFormat("000");

        licenseNum = nf.format(Integer.valueOf(licenseNum));// licenseNum¸ñÊ½»¯³ÉÈýÎ»Êý×Ö

        String verTime = new StringBuilder("-").append(

                new java.text.SimpleDateFormat("yyMMdd").format(cal.getTime())) .append("0").toString();// ÈÕÆÚ

        String type = "YE3MP-";

        String need = new StringBuilder(subscriber.substring(0, 1)) .append(type).append("300").append(licenseNum).append(verTime) .toString();// ³õ²½×¢²áÐÅÏ¢

        String dx = new StringBuilder(need).append(LL).append(subscriber) .toString();

        int suf = this.decode(dx);// ±àÂë³õ²½×¢²áÐÅÏ¢

        String code = new StringBuilder(need).append(String.valueOf(suf)) .toString();

        return this.change(code);
    }

    private int decode(String s) {
        int i;

        char[] ac;

        int j;

        int k;

        i = 0;

        ac = s.toCharArray();// °Ñs×ª»¯Îªµ¥¸ö×Ö·ûÊý×é

        j = 0;

        k = ac.length;

        while (j < k)

        {

            i = (31 * i) + ac[j];//¼ÓÃÜËã·¨£¬²»Àí½âÎªÊ²Ã´ÕâÑù×Ó£¿ÓÐ¿ÉÄÜ¾ÍÊÇÕâÑù×Ó¶¨ÒåµÄ

            j++;

        }

        System.out.println();

        return Math.abs(i);//È¡¾ø¶ÔÖµ
    }
    /**
     * ±ä»¯Ô­ÔòÊÇ
     * °ÑÊý×Ö£¨10¸ö£©»òÕß×ÖÄ¸±í£¨´óÐ¡Ð´¸ö26¸ö£©ÕÛ°ë¶Ôµ÷£¨Á½¸öÏà»¥¸Ä±ä£©£¬Ò²¼´
     * 0Óë5¶Ôµ÷£¨0±ä5£¬5±ä0£©
     * AÓëN£¬aÓën¶Ôµ÷
     * @param ­×Ö·û´®
     * @return ±ä»¯ºóµÄ×Ö·û´®
     */
    private String change(String s) {
        byte[] abyte0;

        char[] ac = null;

        int i;

        int k;

        int j;

        abyte0 = s.getBytes();

        ac = new char[abyte0.length];

        i = 0;

        k = abyte0.length;

        while (i < k)

        {

            j = abyte0[i];

            if ((j >= 48) && (j <= 57))// 0-9,ÊµÏÖ01234ºÍ56789ÏàÓ¦µÄÏà»¥¶Ôµ÷£¬Ò²¼´0Óë5¶Ôµ÷£¬1Óë6¶Ôµ÷

            {

                j = (((j - 48) + 5) % 10) + 48;

            } else if ((j >= 65) && (j <= 90))// A-Z

            {

                j = (((j - 65) + 13) % 26) + 65;

            } else if ((j >= 97) && (j <= 122))// a-z

            {

                j = (((j - 97) + 13) % 26) + 97;

            }

            ac[i] = (char) j;

            i++;

        }

        return String.valueOf(ac);
    }

    /**
     * Ö÷·½·¨£¬Ê×ÏÈµ÷ÓÃ£¬²úÉú×¢²áÂë(Subscription Code)
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print("ÇëÊäÈë×¢²áµÄÓÃ»§Ãû(²»Ö§³ÖÖÐÎÄ):");
        Scanner scanner = new Scanner(System.in);//ÊäÈëÁ÷
        String subscriber = scanner.nextLine();//¶ÁÏÂÒ»ÐÐ×Ö·û´®
        MyEclipseKeyGen myeclipseKeyGen = new MyEclipseKeyGen();//ÊµÀý»¯
        String subscription_Code = myeclipseKeyGen.getSerial(subscriber, "1");// ºóÃæµÄ²ÎÊýÊÇÒ»¸öÊý×ÖÀàÐÍµÄ×Ö·û´®,Êý×Ö·¶Î§Îª0-999
        System.out.println("\n" + "MyEclipse×¢²áÂëÉú³ÉµÄ½á¹ûÈçÏÂ" + "\n");
        System.out.println("Subscriber:" + subscriber);
        System.out.println("Subscription Code:" + subscription_Code);
    }
}