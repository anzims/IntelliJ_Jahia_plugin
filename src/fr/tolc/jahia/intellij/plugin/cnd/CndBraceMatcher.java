package fr.tolc.jahia.intellij.plugin.cnd;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import fr.tolc.jahia.intellij.plugin.cnd.psi.CndTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: find a way for < and > to complete in namespace declarations
public class CndBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] PAIRS = new BracePair[]{
            new BracePair(CndTypes.LEFT_ANGLE_BRACKET, CndTypes.RIGHT_ANGLE_BRACKET, true),
            new BracePair(CndTypes.LEFT_BRACKET, CndTypes.RIGHT_BRACKET, true),
            new BracePair(CndTypes.LEFT_PARENTHESIS, CndTypes.RIGHT_PARENTHESIS, true)
    };

    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}