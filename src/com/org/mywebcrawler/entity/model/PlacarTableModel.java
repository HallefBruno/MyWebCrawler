package com.org.mywebcrawler.entity.model;

import com.org.mywebcrawler.entity.Placar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PlacarTableModel extends AbstractTableModel {

    private List<Placar> listPlacar;
    private final String[] colunas = new String[]{"Status", "Time 1", "Gols", "Time 2", "Gols", "Link"};

    public PlacarTableModel(List<Placar> listPlacar) {
        this.listPlacar = listPlacar;
    }

    public PlacarTableModel() {
        this.listPlacar = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listPlacar.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public void setValueAt(Placar aValue, int rowIndex) {
        Placar placar = listPlacar.get(rowIndex);

        placar.setStatus(aValue.getStatus());
        placar.setPrimeiroTime(aValue.getPrimeiroTime());
        placar.setGolsPrimeiroTime(aValue.getGolsPrimeiroTime());
        placar.setSegundoTime(aValue.getSegundoTime());
        placar.setGolsSeguntoTime(aValue.getGolsSeguntoTime());
        placar.setLink(aValue.getLink());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Placar placar = listPlacar.get(rowIndex);

        switch (columnIndex) {
            case 0:
                placar.setStatus(aValue.toString());
            case 1:
                placar.setPrimeiroTime(aValue.toString());
            case 2:
                placar.setGolsPrimeiroTime(aValue.toString());
            case 3:
                placar.setSegundoTime(aValue.toString());
            case 4:
                placar.setGolsSeguntoTime(aValue.toString());
            case 5:
                placar.setLink(aValue.toString());
            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Placar placar = listPlacar.get(rowIndex);
        String valueObject = null;
        switch (columnIndex) {
            case 0:
                valueObject = placar.getStatus();
                break;
            case 1:
                valueObject = placar.getPrimeiroTime();
                break;
            case 2:
                valueObject = placar.getGolsPrimeiroTime();
                break;
            case 3:
                valueObject = placar.getSegundoTime();
                break;    
            case 4:
                valueObject = placar.getGolsSeguntoTime();
                break; 
            case 5:
                valueObject = placar.getLink();
                break; 
                
            default:
                System.err.println("Índice inválido para propriedade do bean Placar.class");
        }

        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Placar getPlacar(int indiceLinha) {
        return listPlacar.get(indiceLinha);
    }

    public void addPlacar(Placar placar) {
        listPlacar.add(placar);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeUsuario(int indiceLinha) {
        listPlacar.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeUsuarios(List<Placar> novosPlacar) {
        int tamanhoAntigo = getRowCount();
        listPlacar.addAll(novosPlacar);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        listPlacar.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return listPlacar.isEmpty();
    }

}
