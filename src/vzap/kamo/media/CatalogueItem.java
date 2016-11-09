package vzap.kamo.media;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CatalogueItem
{


		private Media mediaItem;
		private String userName;
		private String dateAdded;
		private Date d;
		private SimpleDateFormat sdf;

		public CatalogueItem(Media mediaItem, String userName)
		{
			d = new Date();
			sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss Z G");
			this.mediaItem = mediaItem;
			this.userName = userName;

			this.dateAdded = sdf.format(d);

		}

		/**
		 * @return the dateAdded
		 */
		public String getDateAdded()
		{
			return dateAdded;
		}

		/**
		 * @param dateAdded
		 *            the dateAdded to set
		 */
		public void setDateAdded(String dateAdded)
		{
			this.dateAdded = dateAdded;
		}

		/**
		 * @return the mediaItem
		 */
		public Media getMediaItem()
		{
			return mediaItem;
		}

		/**
		 * @param mediaItem
		 *            the mediaItem to set
		 */
		public void setMediaItem(Media mediaItem)
		{
			this.mediaItem = mediaItem;
		}

		/**
		 * @return the userName
		 */
		public String getUserName()
		{
			return userName;
		}

		/**
		 * @param userName
		 *            the userName to set
		 */
		public void setUserName(String userName)
		{
			this.userName = userName;
		}
		
	    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
		@Override
		public String toString()
		{
			return "CatalogueItem [mediaItem=" + mediaItem.toString() + ", userName=" + userName + ", dateAdded=" + dateAdded + "]";
		}
	}


