package com.ramusthastudio.plugin.unixtimestamp.hints.stylesheet;

import com.intellij.codeInsight.hints.InlayHintsCollector;
import com.intellij.codeInsight.hints.InlayHintsSink;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.css.CssFile;
import com.ramusthastudio.plugin.unixtimestamp.hints.BaseInlayHintsCollector;
import com.ramusthastudio.plugin.unixtimestamp.hints.PlainTextUnixTimestampInlayHints;
import com.ramusthastudio.plugin.unixtimestamp.settings.AppSettingsState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CSSUnixTimestampInlayHints extends PlainTextUnixTimestampInlayHints {

  @Nullable
  @Override
  public InlayHintsCollector getCollectorFor(@NotNull PsiFile file,
      @NotNull Editor editor,
      @NotNull AppSettingsState settingsState,
      @NotNull InlayHintsSink inlayHintsSink) {
    return new BaseInlayHintsCollector(editor, settingsState, CssFile.class);
  }

  @Override
  public boolean isLanguageSupported(@NotNull Language language) {
    return "CSS".equals(language.getID());
  }
}