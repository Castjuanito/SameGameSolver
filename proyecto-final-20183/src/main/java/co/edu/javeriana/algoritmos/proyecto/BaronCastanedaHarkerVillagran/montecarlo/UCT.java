package co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran.montecarlo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran.Nodo;

public class UCT {

    public static double uctValue(int totalVisit, double nodeWinScore, int nodeVisit) {
        if (nodeVisit == 0) {
            return Integer.MAX_VALUE;
        }
        return (nodeWinScore / (double) nodeVisit) + 1.41 * Math.sqrt(Math.log(totalVisit) / (double) nodeVisit);
    }

    static Nodo findBestNodeWithUCT(Nodo node) {
        int parentVisit = node.getVisitas();
        return Collections.max(
          node.getHijos(),
          Comparator.comparing(c -> uctValue(parentVisit, c.getPuntaje(), c.getVisitas())));
    }
}
