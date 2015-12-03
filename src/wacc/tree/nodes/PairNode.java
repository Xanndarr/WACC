package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.ExpNode;
import wacc.tree.nodeInterfaces.TypeNode;
import wacc.util.Type;

public class PairNode implements TypeNode {

    private final Type fst;
    private final Type snd;

    public PairNode(Type fst, Type snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public void generate() {

    }
}
