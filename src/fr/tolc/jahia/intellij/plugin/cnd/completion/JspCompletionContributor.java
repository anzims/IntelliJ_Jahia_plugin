package fr.tolc.jahia.intellij.plugin.cnd.completion;

import java.util.List;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.psi.xml.XmlElementType;
import com.intellij.util.ProcessingContext;
import fr.tolc.jahia.intellij.plugin.cnd.model.ViewModel;
import fr.tolc.jahia.intellij.plugin.cnd.references.ViewReferenceProvider;
import fr.tolc.jahia.intellij.plugin.cnd.utils.CndProjectFilesUtil;
import org.jetbrains.annotations.NotNull;

public class JspCompletionContributor extends CompletionContributor {
    public JspCompletionContributor() {
        //Namespaces
        
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(XmlElementType.XML_ATTRIBUTE_VALUE_TOKEN),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                            ProcessingContext context,
                            @NotNull CompletionResultSet resultSet) {

                        PsiElement element = parameters.getOriginalPosition();
                        if (element != null) {
                            PsiElement elementParent = element.getParent();
                            if (elementParent instanceof XmlAttributeValue) {
                                ViewModel viewModel = ViewReferenceProvider.getViewModelFromJspTagAttributeValue((XmlAttributeValue) elementParent, parameters.getOriginalFile().getVirtualFile());

                                if (viewModel != null) {
                                    List<ViewModel> nodeTypeViews = CndProjectFilesUtil.getNodeTypeViews(element, viewModel.getNodeType().getNamespace(), viewModel.getNodeType().getNodeTypeName(), viewModel.getType());

                                    for (ViewModel nodeTypeView : nodeTypeViews) {
                                        resultSet.addElement(LookupElementBuilder.create(nodeTypeView.getFormattedName()));
                                    }
                                }
                            }
                        }
                    }
                }
        );
    }
    
}
