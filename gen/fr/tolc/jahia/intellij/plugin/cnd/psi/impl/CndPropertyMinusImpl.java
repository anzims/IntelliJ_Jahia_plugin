// This is a generated file. Not intended for manual editing.
package fr.tolc.jahia.intellij.plugin.cnd.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static fr.tolc.jahia.intellij.plugin.cnd.psi.CndTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import fr.tolc.jahia.intellij.plugin.cnd.psi.*;

public class CndPropertyMinusImpl extends ASTWrapperPsiElement implements CndPropertyMinus {

  public CndPropertyMinusImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CndVisitor visitor) {
    visitor.visitPropertyMinus(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CndVisitor) accept((CndVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CndPropertyBinary getPropertyBinary() {
    return findChildByClass(CndPropertyBinary.class);
  }

  @Override
  @Nullable
  public CndPropertyBoolean getPropertyBoolean() {
    return findChildByClass(CndPropertyBoolean.class);
  }

  @Override
  @Nullable
  public CndPropertyDate getPropertyDate() {
    return findChildByClass(CndPropertyDate.class);
  }

  @Override
  @Nullable
  public CndPropertyDouble getPropertyDouble() {
    return findChildByClass(CndPropertyDouble.class);
  }

  @Override
  @Nullable
  public CndPropertyLong getPropertyLong() {
    return findChildByClass(CndPropertyLong.class);
  }

  @Override
  @Nullable
  public CndPropertyString getPropertyString() {
    return findChildByClass(CndPropertyString.class);
  }

  @Override
  @Nullable
  public CndPropertyWeakreference getPropertyWeakreference() {
    return findChildByClass(CndPropertyWeakreference.class);
  }

}
