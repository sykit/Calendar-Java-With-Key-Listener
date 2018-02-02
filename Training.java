import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Training extends JFrame implements KeyListener {
    static int tahun = 1984;
    static Scanner sc = new Scanner(System.in);
    static String[] bulan = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    static int[] umrbulan = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static int spasi = 0;
    static int b = 0;
    JLabel label;
    static int day = 1;
    static int bulan2 = 0;
    static int c = 0;
    static int SpasiAkhir = 7;
    static int SpasiAwal = 0;
    static int f = 0;
    static int k = 0;
    private static final String WEEKDAYS = "Su Mo Tu We Th Fr Sa";
    private static final String NEW_LINE = "\n";
    private static final String EMPTY_STRING = " ";
    private static final String TRIPLE_EMPTY_STRING = "   ";

    public Training(String s) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Key Listener Area!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);
    }

    public void updatetahun() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            ;
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            ;
        if (e.getKeyCode() == KeyEvent.VK_UP)
            ;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            ;
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            ;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            ;
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            ;
        if (e.getKeyCode() == KeyEvent.VK_UP)
            ;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            ;
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            ;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {

        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            bulan2--;
            final String calendarString = kalendar2(1, 7);
            System.out.println(calendarString);

        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            bulan2++;
            final String calendarString = kalendar(1, 7);
            System.out.println(calendarString);
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);

        }

    }

    public static void main(String[] args) {
        final String calendarString = kalendar(1, 7);
        System.out.println(calendarString);
        new Training("");

    }

    private static String kalendar(final int startDay, final int endDay) {
        final StringBuilder calendar = new StringBuilder();
        if (bulan2 > 11) {
            bulan2 = 0;
            tahun++;
        }
        
        calendar.append(bulan[bulan2]);
        for(int i = bulan[bulan2].length(); i< 16;i++){
            calendar.append(EMPTY_STRING);
        }
        calendar.append(tahun).append(NEW_LINE);
        calendar.append(WEEKDAYS).append(NEW_LINE);
        SpasiAwal = SpasiAkhir;
        if(tahun >= 1984){
            if(tahun % 4 == 0){
                umrbulan[1]= 29;
            }
            else umrbulan[1]= 28;
        }
        else umrbulan[1]= 28;
        if (SpasiAkhir > 0) {
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 7; j++) {
                    if (i == 1 && day > umrbulan[bulan2] || i == 2 && day > umrbulan[bulan2]) {
                        day = 1;
                    }
                    if (i == 5 && day > umrbulan[bulan2] || i == 6 && day > umrbulan[bulan2]) {
                        calendar.append(TRIPLE_EMPTY_STRING);
                    } else if (i == 1 && day > 10 || SpasiAkhir > 0) {
                        calendar.append(TRIPLE_EMPTY_STRING);
                        SpasiAkhir--;
                        continue;
                    } else if (day / 10 >= 1) {
                        calendar.append(day).append(EMPTY_STRING);
                    } else {
                        calendar.append(EMPTY_STRING).append(day).append(EMPTY_STRING);
                    }
                    if (i == 6 && day <= umrbulan[bulan2]
                            || i == 5 && umrbulan[bulan2] - day >= 0 && umrbulan[bulan2] - day + j < 7) {
                        c++;
                    }
                    if(SpasiAkhir == 0){day++;}

                }
                calendar.append(NEW_LINE);
            }
        } else {
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 7; j++) {
                    if (i == 1 && day > umrbulan[bulan2] || i == 2 && day > umrbulan[bulan2]) {
                        day = 1;
                    }
                    if (i == 5 && day > umrbulan[bulan2] || i == 6 && day > umrbulan[bulan2]) {
                        calendar.append(TRIPLE_EMPTY_STRING);
                    } else if (i == 1 && day > 10 || SpasiAkhir > 0) {
                        calendar.append(TRIPLE_EMPTY_STRING);
                        SpasiAkhir--;
                    }  else if (day / 10 >= 1) {
                        calendar.append(day).append(EMPTY_STRING);
                    } else {
                        calendar.append(EMPTY_STRING).append(day).append(EMPTY_STRING);
                    }
                     if (i == 6 && day <= umrbulan[bulan2]
                            || i == 5 && umrbulan[bulan2] - day >= 0 && umrbulan[bulan2] - day + j < 7) {
                        c++;
                    
                    }
                    day++;

                }
                calendar.append(NEW_LINE);
            }
        }

        SpasiAkhir = c;
        c = 0;
        return calendar.toString();

    }

    private static String kalendar2(final int startDay, final int endDay) {
        final StringBuilder calendar = new StringBuilder();
              
        if(tahun >= 1984){
            if(tahun % 4 == 0){
                umrbulan[1]= 29;
            }
            else umrbulan[1]= 28;
        }
        else umrbulan[1]= 28;
        
        if (bulan2 < 0) {
            bulan2 = 11;
            tahun--;
            
        }
        calendar.append(bulan[bulan2]);
        for(int i = bulan[bulan2].length(); i< 16;i++){
            calendar.append(EMPTY_STRING);
        }
        calendar.append(tahun).append(NEW_LINE);
        calendar.append(WEEKDAYS).append(NEW_LINE);
        
        
        
        f = 7-SpasiAwal;
        SpasiAwal = 42 - f- umrbulan[bulan2];
        while(SpasiAwal>7){
            SpasiAwal = SpasiAwal - 7;
        }
        SpasiAkhir = SpasiAwal;
        if (SpasiAkhir > 0) {
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 7; j++) {
                    if (i == 1 && day > umrbulan[bulan2] || i == 2 && day > umrbulan[bulan2]) {
                        day = 1;
                    }
                    if (i == 5 && day > umrbulan[bulan2] || i == 6 && day > umrbulan[bulan2]) {
                        calendar.append(TRIPLE_EMPTY_STRING);
                    } else if (i == 1 && day > 10 || SpasiAkhir > 0) {
                        calendar.append(TRIPLE_EMPTY_STRING);
                        SpasiAkhir--;
                        continue;
                    } else if (day / 10 >= 1) {
                        calendar.append(day).append(EMPTY_STRING);
                    } else {
                        calendar.append(EMPTY_STRING).append(day).append(EMPTY_STRING);
                    }
                    if (i == 6 && day <= umrbulan[bulan2]
                            || i == 5 && umrbulan[bulan2] - day >= 0 && umrbulan[bulan2] - day + j < 7) {
                        c++;
                    }
                    if(SpasiAkhir == 0){day++;}

                }
                calendar.append(NEW_LINE);
            }
        } else {
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 7; j++) {
                    if (i == 1 && day > umrbulan[bulan2] || i == 2 && day > umrbulan[bulan2]) {
                        day = 1;
                    }
                    if (i == 5 && day > umrbulan[bulan2] || i == 6 && day > umrbulan[bulan2]) {
                        calendar.append(TRIPLE_EMPTY_STRING);
                    } else if (i == 1 && day > 10 || SpasiAkhir > 0) {
                        calendar.append(TRIPLE_EMPTY_STRING);
                        SpasiAkhir--;
                    }  else if (day / 10 >= 1) {
                        calendar.append(day).append(EMPTY_STRING);
                    } else {
                        calendar.append(EMPTY_STRING).append(day).append(EMPTY_STRING);
                    }
                     if (i == 6 && day <= umrbulan[bulan2]
                            || i == 5 && umrbulan[bulan2] - day >= 0 && umrbulan[bulan2] - day + j < 7) {
                        c++;
                    
                    }
                    day++;

                }
                calendar.append(NEW_LINE);
            }
        }

        SpasiAkhir = c;
        c = 0;
        return calendar.toString();

    }
}
