import java.util.*;

public class PerfectSquares {
  public static void main(String[] args) {

  }

  public int perfSqr(int n) {
    int srv = (int) Math.sqrt(n);
    if (srv * srv == n)
      return 0;
    else
      return n - (srv * srv);
  }
}
