package org.practice;

import java.util.*;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int distFromOrigin() {
    // ignoring sqrt
    return (x * x) + (y * y);
  }
}

class KClosestPointsToOrigin {

  public static List<Point> findClosestPoints(Point[] points, int k) {
    ArrayList<Point> result = new ArrayList<>();
    PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((n1,n2)-> ((n2.x*n2.x - n2.y*n2.y)-(n1.x*n1.x - n1.y*n1.y)));
    Arrays.stream(points).forEach(e->maxHeap.add(e));
    maxHeap.stream().limit(k).forEach(e->result.add(e));
    return result;
  }

  public static void main(String[] args) {
    Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
    List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
    System.out.print("Here are the k points closest the origin: ");
    for (Point p : result)
      System.out.print("[" + p.x + " , " + p.y + "] ");
  }
}
