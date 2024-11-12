// RectangleManager.java

import java.util.*;

public class RectangleManager {
    public static void analyzeRectangles(List<Rectangle> rectangles) {
        // System.out.println(0);
        // System.out.println(0);
        // System.out.println(0);
        // System.out.println(0);
        int cnt1 = 0;
        int flag = 1;
        for (Rectangle r : rectangles) {
            if (flag == 1) {
                flag = 0;
                continue;
            }
            if (Math.min(r.getHeight(), r.getWidth()) <= Math.min(rectangles.get(0).getHeight(),
                    rectangles.get(0).getWidth())
                    && Math.max(r.getHeight(), r.getWidth()) <= Math.max(rectangles.get(0).getHeight(),
                            rectangles.get(0).getWidth())) {
                cnt1++;
            }
        }
        System.out.println(cnt1);
        flag = 1;
        int cnt2 = 0;
        for (Rectangle r : rectangles) {
            if (flag == 1) {
                flag = 0;
                continue;
            }
            if (Math.min(r.getHeight(), r.getWidth()) >= Math.min(rectangles.get(0).getHeight(),
                    rectangles.get(0).getWidth())
                    && Math.max(r.getHeight(), r.getWidth()) >= Math.max(rectangles.get(0).getHeight(),
                            rectangles.get(0).getWidth())) {
                cnt2++;
            }
        }
        System.out.println(cnt2);
        int ind3 = 0;
        double ratio1 = rectangles.get(0).getWidth() / rectangles.get(0).getHeight();
        double ratio2 = rectangles.get(0).getHeight() / rectangles.get(0).getWidth();
        double absDiff = 1e9;
        int ans = 0;
        flag = 1;
        for (Rectangle r : rectangles) {
            if (flag == 1) {
                flag = 0;
                continue;
            }
            ind3++;
            double r1 = r.getWidth() / r.getHeight();
            double r2 = r.getHeight() / r.getWidth();
            if (Math.abs(r1 - ratio1) < absDiff) {
                absDiff = Math.abs(r1 - ratio1);
                ans = ind3;
            }
            if (Math.abs(r1 - ratio2) < absDiff) {
                absDiff = Math.abs(r1 - ratio2);
                ans = ind3;
            }
            if (Math.abs(r2 - ratio1) < absDiff) {
                absDiff = Math.abs(r2 - ratio1);
                ans = ind3;
            }
            if (Math.abs(r2 - ratio2) < absDiff) {
                absDiff = Math.abs(r2 - ratio2);
                ans = ind3;
            }
        }
        System.out.println(ans);

        // for (int i = 0; i<rectangles.size(); i++) {
        // for (int j = i; j<rectangles.size(); j++) {
        // if (Math.min(rectangles.get(j).getHeight(), rectangles.get(j).getWidth())
        // < Math.min(rectangles.get(i).getHeight(), rectangles.get(i).getWidth())) {
        // Rectangle temp = rectangles.get(i);
        // rectangles.set(i, rectangles.get(j));
        // rectangles.set(j, temp);
        // } else if (Math.min(rectangles.get(j).getHeight(),
        // rectangles.get(j).getWidth())
        // == Math.min(rectangles.get(i).getHeight(), rectangles.get(i).getWidth())) {
        // if (Math.max(rectangles.get(j).getHeight(), rectangles.get(j).getWidth())
        // < Math.max(rectangles.get(i).getHeight(), rectangles.get(i).getWidth())) {
        // Rectangle temp = rectangles.get(i);
        // rectangles.set(i, rectangles.get(j));
        // rectangles.set(j, temp);
        // }
        // }
        // }
        // }
        // for (Rectangle r:rectangles) {
        // System.out.println(r.getHeight() + " " + r.getWidth());
        // }

        // create a matrix of size NxN -> store 0 or 1...based on whether it fits in the
        // other one or not
        // output = max(sum of the diagonal (bottom left to top right) + 1)

        // int[][] a = new int[rectangles.size()][rectangles.size()];
        // for (int i = 0; i < rectangles.size(); i++) {
        // for (int j = 0; j < rectangles.size(); j++) {
        // a[i][j] = 0;
        // if (rectangles.get(i).fitsIn(rectangles.get(j))) {
        // a[i][j] = 1;
        // }
        // }
        // }

        // ans = 0;
        // for (int i = 0; i < rectangles.size(); i++) {
        // int tempAns = 0;
        // for (int j = 0; j <= i; j++) {
        // tempAns += a[i - j][j];
        // }
        // ans = Math.max(ans, tempAns);
        // }
        // System.out.println(ans + 1);

        // for (int i = 0; i < rectangles.size(); i++) {
        // // int tempAns = 0;
        // for (int j = 0; j < rectangles.size(); j++) {
        // System.out.print(a[i][j]);
        // }
        // System.out.println();
        // // ans = Math.max(ans, tempAns);
        // }

        // question 4
        // been trying to find a dp solution....but can't think of anything rn.
        // new approch
        // sort based on the min(width, height);
        // after that, sort based on the max(width, height) -> if they are same;

        // apparently i read the q wrong....it's super simple
        // ans = 0;
        // // System.out.println();
        // for (int i = 0; i < rectangles.size(); i++) {
        // int tempAns = 0;
        // for (int j = 0; j < rectangles.size(); j++) {
        // if (j == i)
        // continue;
        // Rectangle r = rectangles.get(j);
        // if (Math.min(r.getHeight(), r.getWidth()) <=
        // Math.min(rectangles.get(i).getHeight(),
        // rectangles.get(i).getWidth())
        // && Math.max(r.getHeight(), r.getWidth()) <=
        // Math.max(rectangles.get(i).getHeight(),
        // rectangles.get(i).getWidth())) {
        // tempAns++;
        // }
        // }
        // // System.out.println(tempAns);
        // ans = Math.max(ans, tempAns);
        // }
        // // System.out.println();
        // System.out.println(ans);

        // nvm, we have to do dp only...I WAS CORRECT!!!!!

        // we need to create a 2d array of size NxN
        // store whether the rectangle at i can fit in the rectangle at j or not
        // if yes, store 1, else 0

        // int[][] dp = new int[rectangles.size()][rectangles.size()];
        // for (int i = 0; i < rectangles.size(); i++) {
        // for (int j = 0; j < rectangles.size(); j++) {
        // if (i == j) {
        // dp[i][j] = 1;
        // } else {
        // dp[i][j] = 0;
        // if (Math.min(rectangles.get(i).getHeight(), rectangles.get(i).getWidth()) <=
        // Math
        // .min(rectangles.get(j).getHeight(), rectangles.get(j).getWidth())
        // && Math.max(rectangles.get(i).getHeight(), rectangles.get(i).getWidth()) <=
        // Math
        // .max(rectangles.get(j).getHeight(), rectangles.get(j).getWidth())) {
        // dp[i][j] = 1;
        // }
        // }
        // }
        // }
        // // // print the dp array
        // // for (int i = 0; i < rectangles.size(); i++) {
        // // for (int j = 0; j < rectangles.size(); j++) {
        // // System.out.print(dp[i][j]);
        // // }
        // // System.out.println();
        // // }

        // ans = 0;
        // for (int i = 0; i < rectangles.size(); i++) {
        // int tempAns = 0;
        // for (int j = i; j >= 0; j--) {
        // tempAns += dp[i - j][j];
        // }
        // ans = Math.max(ans, tempAns);
        // }

        // System.out.println(ans + 2);

        Collections.sort(rectangles);

        int[] dp = new int[rectangles.size()];
        for (int i = 0; i < rectangles.size(); i++) {
            dp[i] = 1;
        }
        ans = 1;

        for (int i = 1; i < rectangles.size(); i++) {
            for (int j = 0; j < i; j++) {
                // if j can fit in i
                if ((rectangles.get(j).getWidth() <= rectangles.get(i).getWidth()
                        && rectangles.get(j).getHeight() <= rectangles.get(i).getHeight()) ||
                        (rectangles.get(j).getWidth() <= rectangles.get(i).getHeight()
                                && rectangles.get(j).getHeight() <= rectangles.get(i).getWidth())) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

}
