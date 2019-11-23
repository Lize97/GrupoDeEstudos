package Control;

import java.util.List;

    public abstract class GenericController<T>{
    abstract public T buscarPorId(int id); // busca objeto por Id
    abstract public List<T> listar(); // lista o objeto por Id
    
    
}

