package com.sunny.pdf.pdfutility.code;

public class TreeHeight {

    public int maxHeight3(Tree T) {
        int t1l = 0;
        int t2l = 0;

        if(T.l != null){
            t1l = 1 + maxHeight3(T.l);
        }
        if(T.r != null){
            t2l = 1 + maxHeight3(T.r);
        }

        return Math.max(t1l,t2l);
    }

}
