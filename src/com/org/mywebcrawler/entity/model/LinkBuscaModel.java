package com.org.mywebcrawler.entity.model;

import com.org.mywebcrawler.entity.LinkBusca;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class LinkBuscaModel extends DefaultComboBoxModel<LinkBusca> {
    
    private List<LinkBusca> linksBusca = new ArrayList<>();
    private LinkBusca selectedLinkBusca;
    private final static int FIRSTINDEX = 0;
    
    public LinkBuscaModel() {
        this.linksBusca = new ArrayList<>();
    }
    
    public LinkBuscaModel(List<LinkBusca> linksBusca) {
        this.linksBusca.addAll(linksBusca);
        if (getSize() > 0) {
            setSelectedItem(this.linksBusca.get(FIRSTINDEX));
        }
    }

    @Override
    public int getSize() {
        return linksBusca.size();
    }

    @Override
    public LinkBusca getElementAt(int index) {
        return linksBusca.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedLinkBusca = (LinkBusca) anItem;
    }

    @Override
    public LinkBusca getSelectedItem() {
        return (LinkBusca) selectedLinkBusca;
    }
    
    public void addEstado(LinkBusca linkBusca) {
        linksBusca.add(linkBusca);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(linksBusca.get(getSize() - 1));
    }
     
    public void addListEstado(List<LinkBusca> linksBusca) {
        int primeiraLinha = getSize();
        linksBusca.addAll(linksBusca);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + linksBusca.size());
        setSelectedItem(linksBusca.get(getSize() - 1));
    }
     
    public void removeEstado() {
        linksBusca.remove(getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(linksBusca.get(FIRSTINDEX));
    }
     
    public void clear() {
        linksBusca.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }

}
