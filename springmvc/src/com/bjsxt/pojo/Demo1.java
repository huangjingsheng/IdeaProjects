package com.bjsxt.pojo;

import java.util.List;

public class Demo1 {
    private List<People> peo;

    public List<People> getPeo() {
        return peo;
    }

    public void setPeo(List<People> peo) {
        this.peo = peo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"peo\":")
                .append(peo);
        sb.append('}');
        return sb.toString();
    }
}
