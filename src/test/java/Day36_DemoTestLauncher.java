
//import org.junit.platform.launcher.Launcher;
//import org.junit.platform.launcher.LauncherFactory;
//import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
//import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
//
//import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
//
//
//public class Day36_DemoTestLauncher {
//
//    public static void main(String[] args) {
//        Launcher launcher = LauncherFactory.create();
//        SummaryGeneratingListener listener = new SummaryGeneratingListener();
//        launcher.registerTestExecutionListeners(listener);
//
//        launcher.execute(LauncherDiscoveryRequestBuilder.request()
//                .selectors(selectClass(Day36_Test001.class))
//                .build());
//
//        listener.getSummary().printTo(System.out);
//    }
//}