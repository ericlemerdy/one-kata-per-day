package name.lemerdy.eric.Application.Boundaries;

/**
 * Standard Output Port.
 *
 * @param <TUseCaseOutput> Any IUseCaseOutput.
 */
public interface IOutputPortStandard<TUseCaseOutput extends IUseCaseOutput> {
    /**
     * Writes to the Standard Output.
     *
     * @param output The Output Port Message.
     */
    void Standard(TUseCaseOutput output);
}
