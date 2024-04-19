
package hjsssystem;


public class ReportInvoker {
    
    
    private ReportCommand reportCommand;

    public void setReportCommand(ReportCommand reportCommand) {
        this.reportCommand = reportCommand;
    }

    public void displayReport() {
        this.reportCommand.execute();
    }
    
}
