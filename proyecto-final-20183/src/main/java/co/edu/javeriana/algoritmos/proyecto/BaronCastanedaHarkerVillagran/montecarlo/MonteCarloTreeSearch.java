package co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran.montecarlo;

import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran.Arbol;
import co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran.Nodo;
import co.edu.javeriana.algoritmos.proyecto.BaronCastanedaHarkerVillagran.TableroSG;


public class MonteCarloTreeSearch {

    private static final int WIN_SCORE = 10;
    private int level;
    private int opponent;

    public MonteCarloTreeSearch() {
        this.level = 3;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int getMillisForCurrentLevel() {
        return 2 * (this.level - 1) + 1;
    }

    public TableroSG findNextMove(TableroSG TableroSG, int playerNo) {
        long start = System.currentTimeMillis();
        long end = start + 60 * getMillisForCurrentLevel();

        opponent = 2 - playerNo;
        Arbol Arbol = new Arbol();
        Nodo rootNodo = Arbol.getRaiz();
        rootNodo.setTableroFinal(TableroSG);
        

        while (System.currentTimeMillis() < end) {
            // Phase 1 - Selection
            Nodo promisingNodo = selectPromisingNodo(rootNodo);
            
            
            // Phase 2 - Expansion
           // if (promisingNodo.getState().getTableroSG().checkStatus() == TableroSG.IN_PROGRESS)
            if (promisingNodo.getTableroFinal().checkEstado() == TableroSG.EN_PROCESO)
                expandNodo(promisingNodo);

            
            // Phase 3 - Simulation
            Nodo NodoToExplore = promisingNodo;
            if (promisingNodo.getHijos().size() > 0) {
                NodoToExplore = promisingNodo.getHijoRandom();
            }
            int playoutResult = simulateRandomPlayout(NodoToExplore);
            
            
            // Phase 4 - Update
            backPropogation(NodoToExplore, playoutResult);
        }

        Nodo winnerNodo = rootNodo.getHijoMayorPuntaje();
        Arbol.setRaiz(winnerNodo);
        return winnerNodo.getTableroFinal();
    }

    private Nodo selectPromisingNodo(Nodo rootNodo) {
        Nodo nodo = rootNodo;
        while (nodo.getHijos().size() != 0) {
            nodo = UCT.findBestNodeWithUCT(nodo);
        }
        return nodo;
    }

    private void expandNodo(Nodo nodo) {
        List<Nodo> possibleStates = nodo.getEstadosPosibles();
        possibleStates.forEach(Nodo -> {
            Nodo newNodo = new Nodo();
            newNodo.setPadre(nodo);
            //newNodo.getState().setPlayerNo(Nodo.getState().getOpponent());
            nodo.getHijos().add(newNodo);
        });
    }

    private void backPropogation(Nodo nodoToExplore, int playerNo) {
        Nodo tempNodo = nodoToExplore;
        while (tempNodo != null) {
            tempNodo.incrementarVisitas();
           // if (tempNodo.getState().getPlayerNo() == playerNo)
                tempNodo.incrementarPuntaje(nodoToExplore.getPuntaje());
            tempNodo = tempNodo.getPadre();
        }
    }

    private int simulateRandomPlayout(Nodo nodo) {
        Nodo tempNodo = nodo;
        //State tempState = tempNodo.getState();
        int TableroSGStatus = tempNodo.getTableroFinal().checkEstado();

        while (TableroSGStatus == TableroSG.EN_PROCESO) {
            //tempState.togglePlayer();
        	tempNodo.randomPlay();
            TableroSGStatus = tempNodo.getTableroFinal().checkEstado();
        }

        return TableroSGStatus;
    }

}
