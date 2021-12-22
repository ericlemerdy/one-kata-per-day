package name.lemerdy.eric.Application.Boundaries;

/**
 * Use Case.
 *
 * @param <TUseCaseInput> Any Input Message.
 */
public interface IUseCase<TUseCaseInput extends IUseCaseInput> {
    /**
     * Executes the Use Case.
     *
     * @param input Input Message.
     * @return Runnable.
     */
    void Execute(TUseCaseInput input);
}
