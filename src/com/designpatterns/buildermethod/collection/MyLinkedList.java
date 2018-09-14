package com.designpatterns.buildermethod.collection;

import com.designpatterns.buildermethod.comparetor.Comparetor;
import com.designpatterns.buildermethod.sorter.Sorter;
public class MyLinkedList<T> extends  LinkedList<T> {
    private Sorter<T> sorter;
    private Comparetor<T> comparetor;

    public void setSort(Sorter<T> _sorter) {
        this.sorter = _sorter;
    }

    public void setComparetor(Comparetor<T> comparetor) {
        this.comparetor = comparetor;
    }

    public void sort(){
        sorter.sort(this,comparetor);
    }
}