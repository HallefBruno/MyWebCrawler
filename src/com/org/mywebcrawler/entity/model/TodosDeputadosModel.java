package com.org.mywebcrawler.entity.model;

import com.org.mywebcrawler.entity.TodosDeputados;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class TodosDeputadosModel extends DefaultComboBoxModel<TodosDeputados> {
  
  private List<TodosDeputados> todosDeputados = new ArrayList<>();
  private TodosDeputados selectDeputado;
  private final static int FIRSTINDEX = 0;

  public TodosDeputadosModel() {
    this.todosDeputados = new ArrayList<>();
  }

  public TodosDeputadosModel(List<TodosDeputados> todosDeputados) {
    this.todosDeputados.addAll(todosDeputados);
    if (getSize() > 0) {
      setSelectedItem(this.todosDeputados.get(FIRSTINDEX));
    }
  }

  @Override
  public int getSize() {
    return todosDeputados.size();
  }

  @Override
  public TodosDeputados getElementAt(int index) {
    return todosDeputados.get(index);
  }

  @Override
  public void setSelectedItem(Object anItem) {
    selectDeputado = (TodosDeputados) anItem;
  }

  @Override
  public TodosDeputados getSelectedItem() {
    return (TodosDeputados) selectDeputado;
  }

  public void addEstado(TodosDeputados TodosDeputados) {
    todosDeputados.add(TodosDeputados);
    fireIntervalAdded(this, getSize() - 1, getSize() - 1);
    setSelectedItem(todosDeputados.get(getSize() - 1));
  }

  public void addListEstado(List<TodosDeputados> todosDeputados) {
    int primeiraLinha = getSize();
    todosDeputados.addAll(todosDeputados);
    fireIntervalAdded(this, primeiraLinha, primeiraLinha + todosDeputados.size());
    setSelectedItem(todosDeputados.get(getSize() - 1));
  }

  public void removeEstado() {
    todosDeputados.remove(getSelectedItem());
    fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
    setSelectedItem(todosDeputados.get(FIRSTINDEX));
  }

  public void clear() {
    todosDeputados.clear();
    fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
  }
  
}
