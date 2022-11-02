package com.org.mywebcrawler.entity.model;

import com.org.mywebcrawler.entity.Legislatura;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


public class LegislaturaModel extends DefaultComboBoxModel<Legislatura> {
  private List<Legislatura> legislaturas = new ArrayList<>();
  private Legislatura selected;
  private final static int FIRSTINDEX = 0;

  public LegislaturaModel() {
    this.legislaturas = new ArrayList<>();
  }

  public LegislaturaModel(List<Legislatura> legislaturas) {
    this.legislaturas.addAll(legislaturas);
    if (getSize() > 0) {
      setSelectedItem(this.legislaturas.get(FIRSTINDEX));
    }
  }

  @Override
  public int getSize() {
    return legislaturas.size();
  }

  @Override
  public Legislatura getElementAt(int index) {
    return legislaturas.get(index);
  }

  @Override
  public void setSelectedItem(Object anItem) {
    selected = (Legislatura) anItem;
  }

  @Override
  public Legislatura getSelectedItem() {
    return (Legislatura) selected;
  }

  public void add(Legislatura legislatura) {
    legislaturas.add(legislatura);
    fireIntervalAdded(this, getSize() - 1, getSize() - 1);
    setSelectedItem(legislaturas.get(getSize() - 1));
  }

  public void addList(List<Legislatura> legislaturas) {
    int primeiraLinha = getSize();
    legislaturas.addAll(legislaturas);
    fireIntervalAdded(this, primeiraLinha, primeiraLinha + legislaturas.size());
    setSelectedItem(legislaturas.get(getSize() - 1));
  }

  public void remove() {
    legislaturas.remove(getSelectedItem());
    fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
    setSelectedItem(legislaturas.get(FIRSTINDEX));
  }

  public void clear() {
    legislaturas.clear();
    fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
  }
}
