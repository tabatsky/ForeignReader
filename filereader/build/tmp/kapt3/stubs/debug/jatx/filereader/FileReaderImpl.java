package jatx.filereader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J;\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\u0012"}, d2 = {"Ljatx/filereader/FileReaderImpl;", "Ljatx/filereader/FileReader;", "()V", "readFb2File", "Lkotlin/Pair;", "", "Ljatx/filereader/Paragraph;", "Ljatx/filereader/Chapter;", "path", "", "readSection", "section", "Lcom/kursx/parser/fb2/Section;", "lastLine", "", "", "(Lcom/kursx/parser/fb2/Section;[Ljava/lang/Integer;)Lkotlin/Pair;", "readTxtFile", "filereader_debug"})
public final class FileReaderImpl implements jatx.filereader.FileReader {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<jatx.filereader.Paragraph> readTxtFile(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.Pair<java.util.List<jatx.filereader.Paragraph>, java.util.List<jatx.filereader.Chapter>> readFb2File(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    private final kotlin.Pair<java.util.List<jatx.filereader.Paragraph>, java.util.List<jatx.filereader.Chapter>> readSection(com.kursx.parser.fb2.Section section, java.lang.Integer[] lastLine) {
        return null;
    }
    
    @javax.inject.Inject()
    public FileReaderImpl() {
        super();
    }
}