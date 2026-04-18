use orbitmines_explorer::spec::{ArbitraryIterator, ArbitraryNode, ArbitraryRay, Node};

pub struct WasmExplorer {

}

impl<T> Node for T {



    fn rays(&self) -> ArbitraryIterator<ArbitraryRay<bool>> {
        todo!()
    }

    fn observe(&self) -> ArbitraryNode<bool> {
        todo!()
    }

}

impl Node for IpfsNode {}