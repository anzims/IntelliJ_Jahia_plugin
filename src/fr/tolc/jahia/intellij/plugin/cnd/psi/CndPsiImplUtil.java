package fr.tolc.jahia.intellij.plugin.cnd.psi;

import java.util.List;

import javax.swing.*;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import fr.tolc.jahia.intellij.plugin.cnd.icons.CndIcons;
import fr.tolc.jahia.intellij.plugin.cnd.enums.PropertyTypeEnum;
import fr.tolc.jahia.intellij.plugin.cnd.enums.PropertyTypeMaskEnum;
import org.jetbrains.annotations.Nullable;

public class CndPsiImplUtil {

    //Namespace
    public static String getNamespaceName(CndNamespace element) {
        return element.getNamespaceIdentifier().getNamespaceName();
    }

    public static PsiElement setNamespaceName(CndNamespace element, String newName) {
        return element.getNamespaceIdentifier().setNamespaceName(newName);
    }

    public static String getNamespaceURI(CndNamespace element) {
        ASTNode uriNode = element.getNode().findChildByType(CndTypes.NAMESPACE_URI);
        if (uriNode != null) {
            return uriNode.getText();
        }
        return null;
    }

    public static ItemPresentation getPresentation(final CndNamespace element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getNamespaceName() + " = '" + element.getNamespaceURI() + "'";
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return CndIcons.FILE;
            }
        };
    }



    //Namespace Identifier
    public static String getNamespaceName(CndNamespaceIdentifier element) {
        ASTNode nameNode = element.getNode().findChildByType(CndTypes.NAMESPACE_NAME);
        if (nameNode != null) {
            return nameNode.getText();
        }
        return null;
    }

    public static PsiElement setNamespaceName(CndNamespaceIdentifier element, String newName) {
        ASTNode nameNode = element.getNode().findChildByType(CndTypes.NAMESPACE_NAME);
        if (nameNode != null) {
            CndNamespace namespace = CndElementFactory.createNamespace(element.getProject(), newName);
            ASTNode newNamespaceNode = namespace.getNamespaceIdentifier().getNode().findChildByType(CndTypes.NAMESPACE_NAME);
            element.getNode().replaceChild(nameNode, newNamespaceNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(CndNamespaceIdentifier element) {
        ASTNode namespaceNameNode = element.getNode().findChildByType(CndTypes.NAMESPACE_NAME);
        if (namespaceNameNode != null) {
            return namespaceNameNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement setName(CndNamespaceIdentifier element, String newName) {
        return setNamespaceName(element, newName);
    }

    public static String getName(CndNamespaceIdentifier element) {
        return getNamespaceName(element);
    }

    public static CndNamespace getNamespace(CndNamespaceIdentifier element) {
        return (CndNamespace) element.getParent();
    }

    public static ItemPresentation getPresentation(final CndNamespaceIdentifier element) {
        return element.getNamespace().getPresentation();
    }
    
    



    //NodeType
    public static String getNodeTypeName(CndNodeType element) {
        return element.getNodeTypeIdentifier().getNodeTypeName();
    }

    public static PsiElement setNodeTypeName(CndNodeType element, String newName) {
        return element.getNodeTypeIdentifier().setNodeTypeName(newName);
    }

    public static String getNodeTypeNamespace(CndNodeType element) {
        ASTNode namespaceName = element.getNode().findChildByType(CndTypes.NAMESPACE_NAME);
        if (namespaceName != null) {
            return namespaceName.getText();
        }
        return null;
    }

    public static CndProperty getProperty(CndNodeType element, String propertyName) {
        List<CndProperty> properties = element.getPropertyList();
        for (CndProperty property : properties) {
            if (property.getPropertyName().equals(propertyName)) {
                return property;
            }
        }
        return null;
    }

    public static ItemPresentation getPresentation(final CndNodeType element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getNodeTypeNamespace() + ":" + element.getNodeTypeName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return CndIcons.FILE;
            }
        };
    }



    //NodeType Identifier
    public static String getNodeTypeName(CndNodeTypeIdentifier element) {
        ASTNode nameNode = element.getNode().findChildByType(CndTypes.NODE_TYPE_NAME);
        if (nameNode != null) {
            return nameNode.getText();
        }
        return null;
    }

    public static PsiElement setNodeTypeName(CndNodeTypeIdentifier element, String newName) {
        ASTNode nameNode = element.getNode().findChildByType(CndTypes.NODE_TYPE_NAME);
        if (nameNode != null) {
            CndNodeType nodeType = CndElementFactory.createNodeType(element.getProject(), newName);
            ASTNode newNodeTypeNode = nodeType.getNodeTypeIdentifier().getNode().findChildByType(CndTypes.NODE_TYPE_NAME);
            element.getNode().replaceChild(nameNode, newNodeTypeNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(CndNodeTypeIdentifier element) {
        ASTNode nodeTypeNameNode = element.getNode().findChildByType(CndTypes.NODE_TYPE_NAME);
        if (nodeTypeNameNode != null) {
            return nodeTypeNameNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement setName(CndNodeTypeIdentifier element, String newName) {
        return setNodeTypeName(element, newName);
    }

    public static String getName(CndNodeTypeIdentifier element) {
        return getNodeTypeName(element);
    }
    
    public static CndNodeType getNodeType(CndNodeTypeIdentifier element) {
        return (CndNodeType) element.getParent();
    }

    public static ItemPresentation getPresentation(final CndNodeTypeIdentifier element) {
        return element.getNodeType().getPresentation();
    }
    
    
    


    //Property
    public static String getPropertyName(CndProperty element) {
        return element.getPropertyIdentifier().getPropertyName();
    }

    public static PsiElement setPropertyName(CndProperty element, String newName) {
        return element.getPropertyIdentifier().setPropertyName(newName);
    }

    public static PropertyTypeEnum getType(CndProperty element) {
        ASTNode propertyType = element.getNode().findChildByType(CndTypes.PROPERTY_TYPE);
        if (propertyType != null) {
            try {
                return PropertyTypeEnum.fromValue(propertyType.getText());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
        return null;
    }

    public static PropertyTypeMaskEnum getTypeMask(CndProperty element) {
        ASTNode propertyMask = element.getNode().findChildByType(CndTypes.PROPERTY_MASK);
        if (propertyMask != null) {
            try {
                return PropertyTypeMaskEnum.fromValue(propertyMask.getText());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
        return null;
    }

    public static ItemPresentation getPresentation(final CndProperty element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getPropertyName() + " (" + element.getType() + ")";
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return CndIcons.FILE;
            }
        };
    }

    
    
    //Property Identifier
    public static String getPropertyName(CndPropertyIdentifier element) {
        ASTNode nameNode = element.getNode().findChildByType(CndTypes.PROPERTY_NAME);
        if (nameNode != null) {
            return nameNode.getText();
        }
        return null;
    }

    public static PsiElement setPropertyName(CndPropertyIdentifier element, String newName) {
        ASTNode nameNode = element.getNode().findChildByType(CndTypes.PROPERTY_NAME);
        if (nameNode != null) {
            CndProperty property = CndElementFactory.createProperty(element.getProject(), newName);
            ASTNode newPropertyNameNode = property.getPropertyIdentifier().getNode().findChildByType(CndTypes.PROPERTY_NAME);
            element.getNode().replaceChild(nameNode, newPropertyNameNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(CndPropertyIdentifier element) {
        ASTNode propertyNameNode = element.getNode().findChildByType(CndTypes.PROPERTY_NAME);
        if (propertyNameNode != null) {
            return propertyNameNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement setName(CndPropertyIdentifier element, String newName) {
        return setPropertyName(element, newName);
    }

    public static String getName(CndPropertyIdentifier element) {
        return getPropertyName(element);
    }

    public static CndProperty getProperty(CndPropertyIdentifier element) {
        return (CndProperty) element.getParent();
    }
    
    public static ItemPresentation getPresentation(final CndPropertyIdentifier element) {
        return element.getProperty().getPresentation();
    }
    


    //SuperType
    public static PsiReference[] getReferences(CndSuperType element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    //Extension
    public static PsiReference[] getReferences(CndExtension element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    //SubNodeType
    public static PsiReference[] getReferences(CndSubNodeType element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }
    
    //SubNodeDefaultType
    public static PsiReference[] getReferences(CndSubNodeDefaultType element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }
}
