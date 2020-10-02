import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex stationIndex;
    List<Station> stations;
    Line first;
    Line second;
    Line third;

    @Override
    protected void setUp() {
        route = new ArrayList<>();

        first = new Line(1, "Первая линия");
        second = new Line(2, "Вторая линия");
        third = new Line(3, "Третья линия");

        stations = new LinkedList<>();
        stations.add(new Station("1 станция", first));
        stations.add(new Station("2 станция", first));
        stations.add(new Station("3 станция", first));
        stations.add(new Station("3 станция", second));
        stations.add(new Station("4 станция", second));
        stations.add(new Station("5 станция", second));
        stations.add(new Station("5 станция", third));
        stations.add(new Station("6 станция", third));
        stations.add(new Station("7 станция", third));

        for (int i = 0; i < 3; i++) {
            first.addStation(stations.get(i));
        }
        for (int i = 3; i < 6; i++) {
            second.addStation(stations.get(i));
        }
        for (int i = 6; i < 9; i++) {
            third.addStation(stations.get(i));
        }

        List<Station> connection1 = new ArrayList<>();
        connection1.add(new Station("3 станция", first));
        connection1.add(new Station("3 станция", second));

        List<Station> connection2 = new ArrayList<>();
        connection2.add(new Station("5 станция", second));
        connection2.add(new Station("5 станция", third));

        stationIndex = new StationIndex();

        stationIndex.addLine(first);
        stationIndex.addLine(second);
        stationIndex.addLine(third);
        stationIndex.addConnection(connection1);
        stationIndex.addConnection(connection2);
    }

    @Override
    protected void tearDown() {
        route.clear();
        stations.clear();
    }

    @Test
    public void testCalculateDuration() {
        route.add(new Station("1 станция", first));
        route.add(new Station("2 станция", first));
        route.add(new Station("3 станция", second));
        route.add(new Station("4 станция", second));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> routeActual = routeCalculator.getShortestRoute(stations.get(0), stations.get(2));
        List<Station> routeExpected = new LinkedList<>();
        routeExpected.add(new Station("1 станция", first));
        routeExpected.add(new Station("2 станция", first));
        routeExpected.add(new Station("3 станция", first));
        assertEquals(routeExpected, routeActual);
    }

    public void testGetRouteWithOneConnection() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> routeActual = routeCalculator.getShortestRoute(stations.get(1), stations.get(4));
        List<Station> routeExpected = new LinkedList<>();
        routeExpected.add(new Station("2 станция", first));
        routeExpected.add(new Station("3 станция", first));
        routeExpected.add(new Station("3 станция", second));
        routeExpected.add(new Station("4 станция", second));
        assertEquals(routeExpected, routeActual);
    }

    public void testGetRouteWithTwoConnections() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> routeActual = routeCalculator.getShortestRoute(stations.get(1), stations.get(7));
        List<Station> routeExpected = new LinkedList<>();
        routeExpected.add(new Station("2 станция", first));
        routeExpected.add(new Station("3 станция", first));
        routeExpected.add(new Station("3 станция", second));
        routeExpected.add(new Station("4 станция", second));
        routeExpected.add(new Station("5 станция", second));
        routeExpected.add(new Station("5 станция", third));
        routeExpected.add(new Station("6 станция", third));
        assertEquals(routeExpected, routeActual);
    }

    @Test
    public void testCalculateDurationTwoTransfer() {
        route.add(new Station("1 станция", first));
        route.add(new Station("2 станция", first));
        route.add(new Station("2 станция", second));
        route.add(new Station("3 станция", second));
        route.add(new Station("3 станция", third));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 12.0;
        assertEquals(expected, actual);
    }
}
