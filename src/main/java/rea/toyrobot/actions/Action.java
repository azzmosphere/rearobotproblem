package rea.toyrobot.actions;

public interface Action {
    /**
     * The arguments that
     *
     * @param argsIn
     */
    void setArgsIn(String[] argsIn);

    /**
     * returns true if the action can process the request.
     * @param argsIn
     * @return
     */
    boolean canPerformAction(String argsIn[]);
}
