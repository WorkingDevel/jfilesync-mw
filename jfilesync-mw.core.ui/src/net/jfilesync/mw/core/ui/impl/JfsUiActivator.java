package net.jfilesync.mw.core.ui.impl;

import net.jfilesync.mw.core.ui.api.JavaFXRootStageProvider;
import net.jfilesync.mw.core.ui.impl.tracker.RootStageServiceTrackerCustomizer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class JfsUiActivator implements BundleActivator {
  public static boolean started = false;
  ServiceTracker<JavaFXRootStageProvider, JavaFXRootStageProvider> mainStageTracker;

  @Override
  public void start(BundleContext context) throws Exception {
    System.out.println("JfsCoreUI Bundle started");

    mainStageTracker = new ServiceTracker<>(
        context,
        JavaFXRootStageProvider.class,
        new RootStageServiceTrackerCustomizer(context)
    );
    mainStageTracker.open();
  }

  @Override
  public void stop(BundleContext context) throws Exception {
    mainStageTracker.close();
    System.out.println("JfsCoreUI Bundle stopped");
  }
}