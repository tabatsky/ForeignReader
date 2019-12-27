package jatx.foreignreader.presentation;

import jatx.filereader.Chapter;
import jatx.filereader.Paragraph;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import moxy.viewstate.MvpViewState;
import moxy.viewstate.ViewCommand;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.SkipStrategy;

public class MainView$$State extends MvpViewState<MainView> implements MainView {
	@Override
	public void showTranslation(String word, String translation) {
		ShowTranslationCommand showTranslationCommand = new ShowTranslationCommand(word, translation);
		viewCommands.beforeApply(showTranslationCommand);

		if (hasNotView()) {
			return;
		}

		for (MainView view : views) {
			view.showTranslation(word, translation);
		}

		viewCommands.afterApply(showTranslationCommand);
	}

	@Override
	public void showToast(String text) {
		ShowToastCommand showToastCommand = new ShowToastCommand(text);
		viewCommands.beforeApply(showToastCommand);

		if (hasNotView()) {
			return;
		}

		for (MainView view : views) {
			view.showToast(text);
		}

		viewCommands.afterApply(showToastCommand);
	}

	@Override
	public void showFileSelectDialog() {
		ShowFileSelectDialogCommand showFileSelectDialogCommand = new ShowFileSelectDialogCommand();
		viewCommands.beforeApply(showFileSelectDialogCommand);

		if (hasNotView()) {
			return;
		}

		for (MainView view : views) {
			view.showFileSelectDialog();
		}

		viewCommands.afterApply(showFileSelectDialogCommand);
	}

	@Override
	public void setParagraphs(List<Paragraph> paragraphs) {
		SetParagraphsCommand setParagraphsCommand = new SetParagraphsCommand(paragraphs);
		viewCommands.beforeApply(setParagraphsCommand);

		if (hasNotView()) {
			return;
		}

		for (MainView view : views) {
			view.setParagraphs(paragraphs);
		}

		viewCommands.afterApply(setParagraphsCommand);
	}

	@Override
	public void setChapters(List<Chapter> chapters) {
		SetChaptersCommand setChaptersCommand = new SetChaptersCommand(chapters);
		viewCommands.beforeApply(setChaptersCommand);

		if (hasNotView()) {
			return;
		}

		for (MainView view : views) {
			view.setChapters(chapters);
		}

		viewCommands.afterApply(setChaptersCommand);
	}

	@Override
	public void scrollToActualPosition(int paragraphPosition) {
		ScrollToActualPositionCommand scrollToActualPositionCommand = new ScrollToActualPositionCommand(paragraphPosition);
		viewCommands.beforeApply(scrollToActualPositionCommand);

		if (hasNotView()) {
			return;
		}

		for (MainView view : views) {
			view.scrollToActualPosition(paragraphPosition);
		}

		viewCommands.afterApply(scrollToActualPositionCommand);
	}

	@Override
	public void showSpinnerLanguageActualState(int position) {
		ShowSpinnerLanguageActualStateCommand showSpinnerLanguageActualStateCommand = new ShowSpinnerLanguageActualStateCommand(position);
		viewCommands.beforeApply(showSpinnerLanguageActualStateCommand);

		if (hasNotView()) {
			return;
		}

		for (MainView view : views) {
			view.showSpinnerLanguageActualState(position);
		}

		viewCommands.afterApply(showSpinnerLanguageActualStateCommand);
	}

	@Override
	public void updateActiveChapter(int paragraphPosition) {
		UpdateActiveChapterCommand updateActiveChapterCommand = new UpdateActiveChapterCommand(paragraphPosition);
		viewCommands.beforeApply(updateActiveChapterCommand);

		if (hasNotView()) {
			return;
		}

		for (MainView view : views) {
			view.updateActiveChapter(paragraphPosition);
		}

		viewCommands.afterApply(updateActiveChapterCommand);
	}

	public class ShowTranslationCommand extends ViewCommand<MainView> {
		public final String word;

		public final String translation;

		ShowTranslationCommand(String word, String translation) {
			super("showTranslation", SkipStrategy.class);

			this.word = word;
			this.translation = translation;
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.showTranslation(word, translation);
		}
	}

	public class ShowToastCommand extends ViewCommand<MainView> {
		public final String text;

		ShowToastCommand(String text) {
			super("showToast", SkipStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.showToast(text);
		}
	}

	public class ShowFileSelectDialogCommand extends ViewCommand<MainView> {
		ShowFileSelectDialogCommand() {
			super("showFileSelectDialog", SkipStrategy.class);
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.showFileSelectDialog();
		}
	}

	public class SetParagraphsCommand extends ViewCommand<MainView> {
		public final List<Paragraph> paragraphs;

		SetParagraphsCommand(List<Paragraph> paragraphs) {
			super("setParagraphs", AddToEndSingleStrategy.class);

			this.paragraphs = paragraphs;
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.setParagraphs(paragraphs);
		}
	}

	public class SetChaptersCommand extends ViewCommand<MainView> {
		public final List<Chapter> chapters;

		SetChaptersCommand(List<Chapter> chapters) {
			super("setChapters", AddToEndSingleStrategy.class);

			this.chapters = chapters;
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.setChapters(chapters);
		}
	}

	public class ScrollToActualPositionCommand extends ViewCommand<MainView> {
		public final int paragraphPosition;

		ScrollToActualPositionCommand(int paragraphPosition) {
			super("scrollToActualPosition", AddToEndSingleStrategy.class);

			this.paragraphPosition = paragraphPosition;
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.scrollToActualPosition(paragraphPosition);
		}
	}

	public class ShowSpinnerLanguageActualStateCommand extends ViewCommand<MainView> {
		public final int position;

		ShowSpinnerLanguageActualStateCommand(int position) {
			super("showSpinnerLanguageActualState", AddToEndSingleStrategy.class);

			this.position = position;
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.showSpinnerLanguageActualState(position);
		}
	}

	public class UpdateActiveChapterCommand extends ViewCommand<MainView> {
		public final int paragraphPosition;

		UpdateActiveChapterCommand(int paragraphPosition) {
			super("updateActiveChapter", AddToEndSingleStrategy.class);

			this.paragraphPosition = paragraphPosition;
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.updateActiveChapter(paragraphPosition);
		}
	}
}
