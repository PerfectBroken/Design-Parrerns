package com.designpatterns.sixprinciple.work;
import com.designpatterns.sixprinciple.tool.Tool;
public abstract class Work {
    private Tool tool;

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public void working(){
        if (tool != null) {
            tool.useTool();
        }
        doWork();
    }

    abstract void doWork();
}