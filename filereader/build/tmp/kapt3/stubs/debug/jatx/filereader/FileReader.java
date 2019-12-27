package jatx.filereader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Ljatx/filereader/FileReader;", "", "readFb2File", "Lkotlin/Pair;", "", "Ljatx/filereader/Paragraph;", "Ljatx/filereader/Chapter;", "path", "", "readTxtFile", "filereader_debug"})
public abstract interface FileReader {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<jatx.filereader.Paragraph> readTxtFile(@org.jetbrains.annotations.NotNull()
    java.lang.String path);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.Pair<java.util.List<jatx.filereader.Paragraph>, java.util.List<jatx.filereader.Chapter>> readFb2File(@org.jetbrains.annotations.NotNull()
    java.lang.String path);
}