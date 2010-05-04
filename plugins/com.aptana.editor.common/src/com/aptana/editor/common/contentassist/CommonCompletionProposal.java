package com.aptana.editor.common.contentassist;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class CommonCompletionProposal implements ICommonCompletionProposal
{
	private String _additionalProposalInformation;
	private IContextInformation _contextInformation;
	private String _displayString;
	private Image _image;
	private int _cursorPosition;
	private int _replacementOffset;
	private int _replacementLength;
	private String _replacementString;
	private String _fileLocation;
	private boolean _isDefaultSelection;
	private boolean _isSuggestedSelection;
	private Image[] _userAgentImages;

	/**
	 * CommonCompletionProposal
	 * 
	 * @param replacementString
	 * @param replacementOffset
	 * @param replacementLength
	 * @param cursorPosition
	 * @param image
	 * @param displayString
	 * @param contextInformation
	 * @param additionalProposalInfo
	 */
	public CommonCompletionProposal(String replacementString, int replacementOffset, int replacementLength, int cursorPosition, Image image, String displayString, IContextInformation contextInformation, String additionalProposalInfo)
	{
		this._replacementString = replacementString;
		this._replacementOffset = replacementOffset;
		this._replacementLength = replacementLength;
		this._cursorPosition = cursorPosition;
		this._image = image;
		this._displayString = displayString;
		this._contextInformation = contextInformation;
		this._additionalProposalInformation = additionalProposalInfo;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#apply(org.eclipse.jface.text.IDocument)
	 */
	@Override
	public void apply(IDocument document)
	{
		try
		{
			document.replace(this._replacementOffset, this._replacementLength, this._replacementString);
		}
		catch (BadLocationException x)
		{
			// ignore
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getAdditionalProposalInfo()
	 */
	@Override
	public String getAdditionalProposalInfo()
	{
		return this._additionalProposalInformation;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getContextInformation()
	 */
	@Override
	public IContextInformation getContextInformation()
	{
		return this._contextInformation;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getDisplayString()
	 */
	@Override
	public String getDisplayString()
	{
		return this._displayString;
	}

	/*
	 * (non-Javadoc)
	 * @see com.aptana.editor.common.contentassist.ICommonCompletionProposal#getFileLocation()
	 */
	@Override
	public String getFileLocation()
	{
		return (this._fileLocation != null) ? this._fileLocation : "";
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getImage()
	 */
	@Override
	public Image getImage()
	{
		return this._image;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getSelection(org.eclipse.jface.text.IDocument)
	 */
	@Override
	public Point getSelection(IDocument document)
	{
		return new Point(this._replacementOffset + this._cursorPosition, 0);
	}

	/*
	 * (non-Javadoc)
	 * @see com.aptana.editor.common.contentassist.ICommonCompletionProposal#getUserAgentImages()
	 */
	@Override
	public Image[] getUserAgentImages()
	{
		return this._userAgentImages;
	}

	/*
	 * (non-Javadoc)
	 * @see com.aptana.editor.common.contentassist.ICommonCompletionProposal#isDefaultSelection()
	 */
	@Override
	public boolean isDefaultSelection()
	{
		return this._isDefaultSelection;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.aptana.editor.common.contentassist.ICommonCompletionProposal#isSuggestedSelection()
	 */
	@Override
	public boolean isSuggestedSelection()
	{
		return this._isSuggestedSelection;
	}
	
	/**
	 * setLocation
	 * 
	 * @param location
	 */
	public void setFileLocation(String location)
	{
		this._fileLocation = location;
	}
	
	/**
	 * setIsDefaultSelection
	 * 
	 * @param value
	 */
	public void setIsDefaultSelection(boolean value)
	{
		this._isDefaultSelection = value;
	}
	
	/**
	 * setIsSuggstedSelection
	 * 
	 * @param value
	 */
	public void setIsSuggestedSelection(boolean value)
	{
		this._isSuggestedSelection = value;
	}
	
	/**
	 * setUserAgentImages
	 * 
	 * @param images
	 */
	public void setUserAgentImages(Image[] images)
	{
		this._userAgentImages = images;
	}
}
