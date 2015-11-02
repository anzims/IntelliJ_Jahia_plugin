// This is a generated file. Not intended for manual editing.
package fr.smile.jahia.intellij.plugin.cnd.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static fr.smile.jahia.intellij.plugin.cnd.psi.CndTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import fr.smile.jahia.intellij.plugin.cnd.psi.*;

public class CndExtendImpl extends ASTWrapperPsiElement implements CndExtend {

  public CndExtendImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CndVisitor) ((CndVisitor)visitor).visitExtend(this);
    else super.accept(visitor);
  }

}