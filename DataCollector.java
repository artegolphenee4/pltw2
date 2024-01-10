//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DataCollector {
  private ArrayList<String> socialMediaPosts = new ArrayList();
  private ArrayList<String> targetWords = new ArrayList();
  private Scanner sc;
  private int currentPost = 0;
  private int currentTargetWord = 0;

  public DataCollector() {
  }

  public void setData(String socialMediaPostsFilename, String targetWordsFilename) {
    PrintStream var10000;
    String var10001;
    try {
      this.sc = new Scanner(new File(socialMediaPostsFilename));

      while(this.sc.hasNextLine()) {
        String temp = this.sc.nextLine().trim();
        this.socialMediaPosts.add(temp);
      }
    } catch (Exception var5) {
      var10000 = System.out;
      var10001 = String.valueOf(this.socialMediaPosts);
      var10000.println("Error reading or parsing" + var10001 + "\n" + String.valueOf(var5));
    }

    try {
      this.sc = new Scanner(new File(targetWordsFilename));

      while(this.sc.hasNextLine()) {
        this.targetWords.add(this.sc.nextLine().trim());
      }
    } catch (Exception var4) {
      var10000 = System.out;
      var10001 = String.valueOf(this.targetWords);
      var10000.println("Error reading or parsing" + var10001 + "\n" + String.valueOf(var4));
    }

  }

  public String getNextPost() {
    if (this.currentPost < this.socialMediaPosts.size()) {
      ++this.currentPost;
      return (String)this.socialMediaPosts.get(this.currentPost - 1);
    } else {
      return "NONE";
    }
  }

  public void resetPost() {
    this.currentPost = 0;
  }

  public String getNextTargetWord() {
    if (this.currentTargetWord < this.targetWords.size()) {
      ++this.currentTargetWord;
      return (String)this.targetWords.get(this.currentTargetWord - 1);
    } else {
      this.currentTargetWord = 0;
      return "NONE";
    }
  }

  public void prepareAdvertisement(String filename, String usernames, String advertisement) {
    try {
      FileWriter fw = new FileWriter(filename);
      String[] var5 = usernames.split(" ");
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
        String un = var5[var7];
        fw.write("@" + un + " " + advertisement + "\n");
      }

      fw.close();
    } catch (IOException var9) {
      System.out.println("Could not write to file. " + String.valueOf(var9));
    }

  }

  public void printAllPosts() {
    Iterator var1 = this.socialMediaPosts.iterator();

    while(var1.hasNext()) {
      String post = (String)var1.next();
      System.out.println(post);
    }

  }

  public void printAllTargetWords() {
    Iterator var1 = this.targetWords.iterator();

    while(var1.hasNext()) {
      String word = (String)var1.next();
      System.out.println(word);
    }

  }
}
