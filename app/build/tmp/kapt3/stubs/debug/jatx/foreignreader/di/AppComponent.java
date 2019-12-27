package jatx.foreignreader.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Ljatx/foreignreader/di/AppComponent;", "Ljatx/foreignreader/di/Injector;", "Ljatx/foreignreader/ui/MainActivity;", "Ljatx/foreignreader/di/AppDeps;", "Builder", "app_debug"})
@dagger.Component(modules = {jatx.foreignreader.di.AppModule.class, jatx.foreignreader.di.AdaptersModule.class, jatx.foreignreader.di.PresenterModule.class})
public abstract interface AppComponent extends jatx.foreignreader.di.Injector<jatx.foreignreader.ui.MainActivity>, jatx.foreignreader.di.AppDeps {
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0006"}, d2 = {"Ljatx/foreignreader/di/AppComponent$Builder;", "", "build", "Ljatx/foreignreader/di/AppComponent;", "context", "Landroid/content/Context;", "app_debug"})
    @dagger.Component.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract jatx.foreignreader.di.AppComponent.Builder context(@org.jetbrains.annotations.NotNull()
        android.content.Context context);
        
        @org.jetbrains.annotations.NotNull()
        public abstract jatx.foreignreader.di.AppComponent build();
    }
}