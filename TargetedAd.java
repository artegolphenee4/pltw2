//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class TargetedAd {
  public TargetedAd() {
  }

  public static void main(String[] args) {
    DataCollector user = new DataCollector();
    user.setData("socialMediaPostsSmall.txt", "targetWords.txt");
    String username = "";
    String target = user.getNextTargetWord();

    while(true) {
      String post = user.getNextPost();
      if (post.equals("NONE")) {
        target = user.getNextTargetWord();
        user.resetPost();
      }

      if (target.equals("NONE")) {
        System.out.println(username);
        user.prepareAdvertisement("advertisement.txt", username, "advertisement: ");
        return;
      }

      boolean found = false;

      for(int i = 1; i < target.length() && post.indexOf(target.substring(0, i)) >= 0; ++i) {
        if (i == target.length() - 1) {
          found = true;
          break;
        }
      }

      if (found) {
        username = username + post.substring(0, post.indexOf(" ")) + " ";
      }
    }
  }
}
