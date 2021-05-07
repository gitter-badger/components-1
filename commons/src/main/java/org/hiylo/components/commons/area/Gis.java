/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Gis.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.area;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * 地理信息工具类
 * 
 * @author hiylo
 * @date 2018年11月8日 11:26:05
 */
public class Gis {
    private GeometryFactory geometryFactory = new GeometryFactory();

    /**
     * 通过一个个的点转换成mysql的POLYGON 字符串用于插入mysql db
     *
     * @param lntlats 坐标点的数组 中间用","分隔
     * @return 转换之后的字符串
     */
    public String castToMysqlPolygon(String... lntlats) {
        StringBuilder sb = new StringBuilder(" POLYGONFROMTEXT('POLYGON((");
        for (int i = 0; i < lntlats.length; i++) {
            String[] lntlat = lntlats[i].split(",");
            sb.append(lntlat[0]).append(" ").append(lntlat[1]).append(",");
            if (lntlats.length == i + 1) {
                sb.append(lntlats[0].split(",")[0]).append(" ").append(lntlats[0].split(",")[1]);
            }
        }
        sb.append("))')");
        return sb.toString();
    }

    /**
     * 通过点转换成mysql的POINT 字符串用于插入mysql db
     *
     * @param lntlatStr 坐标点 中间用","分隔
     * @return 转换之后的字符串
     */
    public String castToMysqlPoint(String lntlatStr) {
        StringBuilder sb = new StringBuilder(" ST_POINTFROMTEXT('POINT(");
        String[] lntlat = lntlatStr.split(",");
        sb.append(lntlat[0]).append(" ").append(lntlat[1]);
        sb.append(")')");
        return sb.toString();
    }

    /**
     * 通过点转换成mysql的Line 字符串用于插入mysql db
     *
     * @param lntlats 坐标点 中间用","分隔
     * @return 转换之后的字符串
     */
    public String castToMysqlLine(String... lntlats) {
        StringBuilder sb = new StringBuilder(" LINESTRINGFROMTEXT('LINESTRING(");
        for (int i = 0; i < lntlats.length; i++) {
            String[] lntlat = lntlats[i].split(",");
            sb.append(lntlat[0]).append(" ").append(lntlat[1]).append(",");
            if (lntlats.length == i + 1) {
                sb.append(lntlats[0].split(",")[0]).append(" ").append(lntlats[0].split(",")[1]);
            }
        }
        sb.append(")')");
        return sb.toString();
    }

    /**
     * 将一系列点画成一个图形
     * 
     * @param points 点的列表
     * @return 点汇聚成的图形
     * @throws ParseException 解析错误
     */
    public Polygon createPolygon(List<String> points) throws ParseException {
        WKTReader reader = new WKTReader(geometryFactory);
        StringBuilder pointsStr = new StringBuilder("POLYGON((");
        points.forEach(item -> {
            String[] items = item.split(",");
            pointsStr.append(items[0]).append(" ").append(items[1]);
            pointsStr.append(",");
        });
        String firstPoint = points.get(0);
        pointsStr.append(firstPoint.split(",")[0] + " " + firstPoint.split(",")[1]);
        pointsStr.append("))");
        System.out.println(pointsStr);
        return (Polygon) reader.read(pointsStr.toString());
    }

    /**
     * 创建一个点
     * 
     * @param x x坐标
     * @param y y坐标
     * @return 点
     */
    public Point createPoint(double x, double y) {
        Coordinate coord = new Coordinate(x, y);
        Point point = geometryFactory.createPoint(coord);
        return point;
    }

    /**
     * 创建一个矩形
     *
     * @return 矩形
     */
    private Envelope createEnvelope() {
        Envelope envelope = new Envelope(0, 1, 0, 2);
        return envelope;
    }

    /**
     * create a point by WKT
     *
     * @return
     * @throws ParseException
     */
    private Point createPointByWKT(double longitude, double latitude) throws ParseException {
        WKTReader reader = new WKTReader(geometryFactory);
        Point point = (Point) reader.read("POINT (" + longitude + " " + latitude + ")");
        return point;
    }

    /**
     * create multiPoint by wkt
     *
     * @return
     */
    private MultiPoint createMulPointByWKT() throws ParseException {
        WKTReader reader = new WKTReader(geometryFactory);
        MultiPoint mpoint = (MultiPoint) reader.read("MULTIPOINT(109.013388 32.715519,119.32488 31.435678)");
        return mpoint;
    }

    /**
     * create a line
     *
     * @return
     */
    private LineString createLine() {
        Coordinate[] coords = new Coordinate[] { new Coordinate(2, 2), new Coordinate(2, 2) };
        LineString line = geometryFactory.createLineString(coords);
        return line;
    }

    /**
     * create a line by WKT
     *
     * @return
     * @throws ParseException
     */
    private LineString createLineByWKT() throws ParseException {
        WKTReader reader = new WKTReader(geometryFactory);
        LineString line = (LineString) reader.read("LINESTRING(0 0, 2 0)");
        return line;
    }

    /**
     * create multiLine
     *
     * @return
     */
    private MultiLineString createMLine() {
        Coordinate[] coords1 = new Coordinate[] { new Coordinate(2, 2), new Coordinate(2, 2) };
        LineString line1 = geometryFactory.createLineString(coords1);
        Coordinate[] coords2 = new Coordinate[] { new Coordinate(2, 2), new Coordinate(2, 2) };
        LineString line2 = geometryFactory.createLineString(coords2);
        LineString[] lineStrings = new LineString[2];
        lineStrings[0] = line1;
        lineStrings[1] = line2;
        MultiLineString ms = geometryFactory.createMultiLineString(lineStrings);
        return ms;
    }

    /**
     * create multiLine by WKT
     *
     * @return
     * @throws ParseException
     */
    private MultiLineString createMLineByWKT() throws ParseException {
        WKTReader reader = new WKTReader(geometryFactory);
        MultiLineString line = (MultiLineString) reader.read("MULTILINESTRING((0 0, 2 0),(1 1,2 2))");
        return line;
    }

    /**
     * create multi polygon by wkt
     *
     * @return
     * @throws ParseException
     */
    private MultiPolygon createMulPolygonByWKT() throws ParseException {
        WKTReader reader = new WKTReader(geometryFactory);
        MultiPolygon mpolygon = (MultiPolygon) reader
                .read("MULTIPOLYGON(((40 10, 30 0, 40 10, 30 20, 40 10),(30 10, 30 0, 40 10, 30 20, 30 10)))");
        return mpolygon;
    }

    // /**
    // * create GeometryCollection contain point or multiPoint or line or multiLine
    // or polygon or multiPolygon
    // * @return
    // * @throws ParseException
    // */
    // private GeometryCollection createGeoCollect() throws ParseException{
    // LineString line = createLine();
    // Polygon poly = createPolygonByWKT();
    // Geometry g1 = geometryFactory.createGeometry(line);
    // Geometry g2 = geometryFactory.createGeometry(poly);
    // Geometry[] garray = new Geometry[]{g1,g2};
    // GeometryCollection gc = geometryFactory.createGeometryCollection(garray);
    // return gc;
    // }

    /**
     * create a Circle 创建一个圆，圆心(x,y) 半径RADIUS
     *
     * @param x
     * @param y
     * @param RADIUS
     * @return
     */
    private Polygon createCircle(double x, double y, final double RADIUS) {
        final int SIDES = 32;// 圆上面的点个数
        Coordinate[] coords = new Coordinate[SIDES + 1];
        for (int i = 0; i < SIDES; i++) {
            double angle = ((double) i / (double) SIDES) * Math.PI * 2.0;
            double dx = Math.cos(angle) * RADIUS;
            double dy = Math.sin(angle) * RADIUS;
            coords[i] = new Coordinate(x + dx, y + dy);
        }
        coords[SIDES] = coords[0];
        LinearRing ring = geometryFactory.createLinearRing(coords);
        Polygon polygon = geometryFactory.createPolygon(ring, null);
        return polygon;
    }

    /**
     * 判断点是否在多边形内
     *
     * @param point 检测点
     * @param pts   多边形的顶点
     * @return 点在多边形内返回true, 否则返回false
     */
    public static boolean isPtInPoly(Point2D.Double point, List<Point2D.Double> pts) {
        int N = pts.size();
        boolean boundOrVertex = true; // 如果点位于多边形的顶点或边上，也算做点在多边形内，直接返回true
        int intersectCount = 0;// cross points count of x
        double precision = 2e-10; // 浮点类型计算时候与0比较时候的容差
        Point2D.Double p1, p2;// neighbour bound vertices
        Point2D.Double p = point; // 当前点
        p1 = pts.get(0);// left vertex
        for (int i = 1; i <= N; ++i) {// check all rays
            if (p.equals(p1)) {
                return boundOrVertex;// p is an vertex
            }
            p2 = pts.get(i % N);// right vertex
            if (p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)) {// ray is outside of our interests
                p1 = p2;
                continue;// next ray left point
            }
            if (p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)) {// ray is crossing over by the algorithm
                                                                           // (common part of)
                if (p.y <= Math.max(p1.y, p2.y)) {// x is before of ray
                    if (p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)) {// overlies on a horizontal ray
                        return boundOrVertex;
                    }
                    if (p1.y == p2.y) {// ray is vertical
                        if (p1.y == p.y) {// overlies on a vertical ray
                            return boundOrVertex;
                        } else {// before ray
                            ++intersectCount;
                        }
                    } else {// cross point on the left side
                        double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;// cross point of y
                        if (Math.abs(p.y - xinters) < precision) {// overlies on a ray
                            return boundOrVertex;
                        }

                        if (p.y < xinters) {// before ray
                            ++intersectCount;
                        }
                    }
                }
            } else {// special case when ray is crossing through the vertex
                if (p.x == p2.x && p.y <= p2.y) {// p crossing over p2
                    Point2D.Double p3 = pts.get((i + 1) % N); // next vertex
                    if (p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)) {// p.x lies between p1.x & p3.x
                        ++intersectCount;
                    } else {
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;// next ray left point
        }
        if (intersectCount % 2 == 0) {// 偶数在多边形外
            return false;
        } else { // 奇数在多边形内
            return true;
        }
    }

    /**
     * @param args
     * @throws ParseException
     */
    private static void main(String[] args) throws ParseException {
        Gis gt = new Gis();
        Polygon p = gt.createCircle(0, 1, 2);
        // 圆上所有的坐标(32个)
        Coordinate[] coords = p.getCoordinates();
        Envelope envelope = gt.createEnvelope();
    }
}
