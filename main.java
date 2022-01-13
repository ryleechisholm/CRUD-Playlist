package com.company;
import java.util.*;

public class Main {
    private int songno;
    private String name;
    private String artist;

    Main(int songno, String name, String artist){
        this.songno = songno;
        this.name = name;
        this.artist = artist;
    }

    public int getSongno(){
        return songno;
    }
    public String getArtist(){
        return artist;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return songno+" "+name+" "+artist;
    }

    public static void main(String[] args) {
        List<Main> c = new ArrayList<Main>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner myObj = new Scanner(System.in);
        String action = "Hello World";
        do{
            System.out.println("Welcome to your playlist.  What would you like to do?  [create], [read], [update], [delete], or [quit]?");
            action = myObj.nextLine();
            switch(action){
                case "create":
                    System.out.print("Enter Song Number: ");
                    int sno = s.nextInt();
                    System.out.print("Enter Song Name: ");
                    String sname = s1.nextLine();
                    System.out.print("Enter Song Artist: ");
                    String sartist = s1.nextLine();
                    c.add(new Main(sno, sname, sartist));
                    break;
                case "read":
                    boolean found = false;
                    System.out.println("View [all] or enter a song name to search :");
                    String num = s1.nextLine();
                    System.out.println("----------------------");
                    Iterator<Main> i = c.iterator();
                    if (num.equals("all")){
                        while (i.hasNext()){
                            Main e = i.next();
                            System.out.println(e);
                        }
                    }else {
                        while (i.hasNext()) {
                            Main e = i.next();
                            if (e.getName().equals(num)) {
                                System.out.println(e);
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Song not found");
                        }
                    }
                    System.out.println("----------------------");
                    break;
                case "update":
                    found = false;
                    System.out.println("Enter a song name to update :");
                    num = s1.nextLine();
                    System.out.println("----------------------");
                    ListIterator<Main>li = c.listIterator();
                    while (li.hasNext()) {
                        Main e = li.next();
                        if (e.getName().equals(num)) {
                            int songno = e.songno;
                            System.out.println("Enter new song name :");
                            sname = s1.nextLine();
                            System.out.println("Enter new song artist :");
                            sartist = s1.nextLine();
                            li.set(new Main(songno, sname, sartist));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Song not found");
                    }else{
                        System.out.println("Song deleted successfully!");
                    }
                    System.out.println("----------------------");
                    break;
                case "delete":
                    found = false;
                    System.out.println("Enter a song name to delete :");
                    num = s1.nextLine();
                    System.out.println("----------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Main e = i.next();
                        if (e.getName().equals(num)) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Song not found");
                    }else{
                        System.out.println("Song deleted successfully!");
                    }
                    System.out.println("----------------------");
                    break;
            }
        }while (!action.equals("quit"));
    }
}
