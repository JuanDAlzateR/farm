package interfaces;

@FunctionalInterface
public interface IMenuAction {
    Object[] run(Object...arg);
}